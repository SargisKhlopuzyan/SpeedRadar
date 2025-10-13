package com.sargis.khlopuzyan.presentation.ui.radar

import com.sargis.khlopuzyan.presentation.base.UiEvent

sealed interface RadarUiEvent: UiEvent {
    object StartObservingLocation: RadarUiEvent
    object StopObservingLocation: RadarUiEvent
}