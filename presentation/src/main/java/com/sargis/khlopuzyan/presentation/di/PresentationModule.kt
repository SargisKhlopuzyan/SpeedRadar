package com.sargis.khlopuzyan.presentation.di

import com.sargis.khlopuzyan.presentation.ui.main.MainViewModel
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel<MainViewModel> {
        MainViewModel(get())
    }
    viewModel<SettingsViewModel> {
        SettingsViewModel()
    }
}

val presentationModule = listOf(viewModelModule)