package com.sargis.khlopuzyan.presentation.ui.map

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sargis.khlopuzyan.domain.usecase.CurrentLocationUseCase
import com.sargis.khlopuzyan.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MapViewModel(
    private val currentLocationUseCase: CurrentLocationUseCase,
) : BaseViewModel<MapUiState, MapUiEvent>() {

    override val _uiState: MutableStateFlow<MapUiState>
        get() = MutableStateFlow(MapUiState())

    override fun onEvent(event: MapUiEvent) {
        when (event) {
            MapUiEvent.StartObservingLocation -> {
                observeLocation()
            }

            MapUiEvent.StopObservingLocation -> TODO()
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