package com.sargis.khlopuzyan.data.gps

import android.content.Context
import android.location.LocationManager
import com.sargis.khlopuzyan.domain.gps.GpsChecker

class GpsCheckerImpl(private val context: Context) : GpsChecker {

    override fun isGPSEnabled(): Boolean {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        return manager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true
    }
}