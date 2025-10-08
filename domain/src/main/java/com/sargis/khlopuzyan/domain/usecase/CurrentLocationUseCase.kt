package com.sargis.khlopuzyan.domain.usecase

import com.sargis.khlopuzyan.domain.entity.Coordinate
import com.sargis.khlopuzyan.domain.repository.CurrentLocationRepository
import com.sargis.khlopuzyan.domain.util.Result
import kotlinx.coroutines.flow.Flow

class CurrentLocationUseCase(
    private val locationRepository: CurrentLocationRepository,
) {
    suspend fun observeLocation(): Flow<Coordinate> {
        return locationRepository.observeCurrentLocation()
    }

    suspend fun getCurrentLocationOnce(): Result<Coordinate> {
        return locationRepository.getCurrentLocationOnce()
    }

//    fun hasLocationPermissions(): Boolean {
//        return locationRepository.hasLocationPermissions()
//    }
}