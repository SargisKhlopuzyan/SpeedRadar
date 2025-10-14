package com.sargis.khlopuzyan.presentation.di

import com.sargis.khlopuzyan.presentation.ui.map.MapViewModel
import com.sargis.khlopuzyan.presentation.ui.radar.RadarViewModel
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel<RadarViewModel> {
        RadarViewModel(get())
    }
    viewModel<MapViewModel> {
        MapViewModel(get())
    }
    viewModel<SettingsViewModel> {
        SettingsViewModel()
    }
}

val presentationModule = listOf(viewModelModule)