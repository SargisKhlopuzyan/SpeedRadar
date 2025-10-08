package com.sargis.khlopuzyan.presentation.ui.main

import com.sargis.khlopuzyan.presentation.base.UiEvent

sealed interface MainUiEvent: UiEvent {
    object StartObservingLocation: MainUiEvent
    object StopObservingLocation: MainUiEvent
}