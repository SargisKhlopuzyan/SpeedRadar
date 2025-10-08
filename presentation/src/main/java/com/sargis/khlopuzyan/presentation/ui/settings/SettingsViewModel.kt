package com.sargis.khlopuzyan.presentation.ui.settings

import com.sargis.khlopuzyan.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : BaseViewModel<SettingsUiState, SettingsUiEvent>() {

    override val _uiState: MutableStateFlow<SettingsUiState>
        get() = MutableStateFlow(SettingsUiState())

    override fun onEvent(event: SettingsUiEvent) {
//        when(event) {
//
//        }
    }
}