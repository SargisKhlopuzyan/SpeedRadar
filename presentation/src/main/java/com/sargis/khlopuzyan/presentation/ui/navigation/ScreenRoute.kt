package com.sargis.khlopuzyan.presentation.ui.navigation

sealed class ScreenRoute(val route: String) {
    object MainScreen: ScreenRoute("main_screen")
    object SettingsScreen: ScreenRoute("settings_screen")
}