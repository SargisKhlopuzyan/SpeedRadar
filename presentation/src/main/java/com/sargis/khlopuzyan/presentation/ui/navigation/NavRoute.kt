package com.sargis.khlopuzyan.presentation.ui.navigation

sealed class NavRoute(val route: String) {
    object Main: NavRoute("main")
    object Settings: NavRoute("settings")
    object PopUpView: NavRoute("pop_up_view")
    object StartInBackground: NavRoute("start_in_background")
}