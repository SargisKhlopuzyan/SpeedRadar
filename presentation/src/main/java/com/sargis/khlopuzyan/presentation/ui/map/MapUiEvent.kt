package com.sargis.khlopuzyan.presentation.ui.map

import com.sargis.khlopuzyan.presentation.base.UiEvent

sealed interface MapUiEvent: UiEvent {
    object StartObservingLocation: MapUiEvent
    object StopObservingLocation: MapUiEvent
}