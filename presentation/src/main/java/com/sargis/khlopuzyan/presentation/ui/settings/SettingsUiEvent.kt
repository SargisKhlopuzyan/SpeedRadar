package com.sargis.khlopuzyan.presentation.ui.settings

import com.sargis.khlopuzyan.presentation.base.UiEvent

sealed interface SettingsUiEvent: UiEvent {
    object StartObservingLocation: SettingsUiEvent
    object StopObservingLocation: SettingsUiEvent
}