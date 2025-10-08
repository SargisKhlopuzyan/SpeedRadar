package com.sargis.khlopuzyan.domain.repository

import com.sargis.khlopuzyan.domain.entity.Coordinate
import com.sargis.khlopuzyan.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface CurrentLocationRepository {
    suspend fun getCurrentLocationOnce(): Result<Coordinate>
    suspend fun observeCurrentLocation(): Flow<Coordinate>
}