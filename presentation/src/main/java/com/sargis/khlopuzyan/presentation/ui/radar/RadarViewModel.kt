package com.sargis.khlopuzyan.presentation.ui.radar

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sargis.khlopuzyan.domain.usecase.CurrentLocationUseCase
import com.sargis.khlopuzyan.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RadarViewModel(
    private val currentLocationUseCase: CurrentLocationUseCase,
) : BaseViewModel<RadarUiState, RadarUiEvent>() {

    override val _uiState: MutableStateFlow<RadarUiState>
        get() = MutableStateFlow(RadarUiState())

    override fun onEvent(event: RadarUiEvent) {
        when (event) {
            RadarUiEvent.StartObservingLocation -> {
                observeLocation()
            }

            RadarUiEvent.StopObservingLocation -> TODO()
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