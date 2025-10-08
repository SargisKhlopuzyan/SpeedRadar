package com.sargis.khlopuzyan.presentation.ui.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sargis.khlopuzyan.domain.usecase.CurrentLocationUseCase
import com.sargis.khlopuzyan.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(
    private val currentLocationUseCase: CurrentLocationUseCase,
) : BaseViewModel<MainUiState, MainUiEvent>() {

    override val _uiState: MutableStateFlow<MainUiState>
        get() = MutableStateFlow(MainUiState())

    override fun onEvent(event: MainUiEvent) {
        when (event) {
            MainUiEvent.StartObservingLocation -> {
                observeLocation()
            }

            MainUiEvent.StopObservingLocation -> TODO()
        }
    }

    private fun observeLocation() {
        viewModelScope.launch(Dispatchers.IO) {
            currentLocationUseCase.observeLocation().collect { it ->
                Log.e(TAG, "coordinate: $it")
            }
        }
    }

    companion object {
        private const val TAG: String = "LOG-TAG-SR-MainScreen"

    }
}