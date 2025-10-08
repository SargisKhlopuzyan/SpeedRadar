package com.sargis.khlopuzyan.domain.error

enum class GpsError: BaseError {
    FineLocationPermissionNotGranted,
    GpsProviderDisabled,
    LocationRequestTimeout,
    Unknown
}