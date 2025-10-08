package com.sargis.khlopuzyan.data.repository

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest.Builder
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.sargis.khlopuzyan.domain.constant.GET_LOCATION_TIMEOUT
import com.sargis.khlopuzyan.domain.entity.Coordinate
import com.sargis.khlopuzyan.domain.error.GpsError
import com.sargis.khlopuzyan.domain.loger.Logger
import com.sargis.khlopuzyan.domain.repository.CurrentLocationRepository
import com.sargis.khlopuzyan.domain.util.Result
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resume

class CurrentLocationRepositoryImpl(
    private val context: Context,
    private val logger: Logger,
) : CurrentLocationRepository {

    // Define the LocationCallback
    private lateinit var locationCallback: LocationCallback

    // FusedLocationProviderClient instance
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    private val locationManager by lazy {
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocationOnce(): Result<Coordinate> =
        withTimeoutOrNull(GET_LOCATION_TIMEOUT) {
            suspendCancellableCoroutine<Result<Coordinate>> { continuation ->

                // We always want to check GPS provider first
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    logger.e(TAG, "GPS provider disabled")
                    continuation.resume(Result.Error(GpsError.GpsProviderDisabled))
                    return@suspendCancellableCoroutine
                }

                if (!hasAccessFineLocationPermission()) {
                    logger.e(TAG, "Location permissions not granted")
                    continuation.resume(Result.Error(GpsError.FineLocationPermissionNotGranted))
                    return@suspendCancellableCoroutine
                }

                val locationListener = object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        if (continuation.isActive) {
                            continuation.resume(
                                Result.Success(
                                    Coordinate(
                                        location.latitude,
                                        location.longitude
                                    )
                                )
                            )
                            locationManager.removeUpdates(this)
                        }
                    }

                    override fun onProviderEnabled(provider: String) {
                        // not needed
                    }

                    override fun onProviderDisabled(provider: String) {
                        logger.e(TAG, "GPS provider disabled")
                        if (continuation.isActive) {
                            continuation.resume(Result.Error(GpsError.GpsProviderDisabled))
                            locationManager.removeUpdates(this)
                        }
                    }
                }

                try {
                    logger.d(TAG, "Requesting location updates")
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        0L,
                        0f,
                        locationListener
                    )
                } catch (e: CancellationException) {
                    // Directly rethrow CancellationException to allow proper coroutine cancellation
                    throw e
                } catch (e: Exception) {
                    logger.e(TAG, "Error requesting location updates", e)
                    if (continuation.isActive) {
//                        continuation.resume(Result.Error(GpsError.GpsProviderDisabled))
                        continuation.resume(Result.Error(GpsError.Unknown))
                    }
                }

                continuation.invokeOnCancellation {
                    locationManager.removeUpdates(locationListener)
                }
            }

        } ?: Result.Error(GpsError.LocationRequestTimeout)

    override suspend fun observeCurrentLocation(): Flow<Coordinate> = callbackFlow {
        logger.e(TAG, "observeCurrentLocation")
        Log.e(TAG, "observeCurrentLocation")
        trySend(Coordinate(0.0, 0.0))

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        // Create the LocationRequest
        val locationRequest = Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000)
            .setWaitForAccurateLocation(false)
            .setMinUpdateIntervalMillis(5000)
            .build()

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    // Handle the new location here
                    logger.e(TAG, "New location: ${location.latitude}, ${location.longitude}")
                    trySend(Coordinate(location.latitude, location.longitude))
                }
            }
        }

        // Check permissions and request updates
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        }

        awaitClose {
//            stopLocationUpdates()
        }
    }

    private fun hasAccessFineLocationPermission(): Boolean = ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

//    private fun setupLocationListener() {
//
//        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
//
//        // Create the LocationRequest
//        val locationRequest = Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000)
//            .setWaitForAccurateLocation(false)
//            .setMinUpdateIntervalMillis(5000)
//            .build()
//
//        locationCallback = object : LocationCallback() {
//            override fun onLocationResult(locationResult: LocationResult) {
//                for (location in locationResult.locations) {
//                    // Handle the new location here
//                    logger.e(TAG, "New location: ${location.latitude}, ${location.longitude}")
//                }
//            }
//        }
//
//        // Check permissions and request updates
//        if (ActivityCompat.checkSelfPermission(
//                context,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            fusedLocationClient.requestLocationUpdates(
//                locationRequest,
//                locationCallback,
//                Looper.getMainLooper()
//            )
//        }
//    }

    fun stopLocationUpdates() {
        logger.e(TAG, "stopLocationUpdates")
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    private companion object {
        const val TAG = "LOG-TAG-SR-CurrentLocationRepositoryImpl"
    }
}