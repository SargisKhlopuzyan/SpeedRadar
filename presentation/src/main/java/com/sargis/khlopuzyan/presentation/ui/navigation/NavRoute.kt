package com.sargis.khlopuzyan.presentation.ui.navigation

sealed class NavRoute(val route: String) {
    object Main : NavRoute("main")
    object Radar : NavRoute("radar")
    object Map : NavRoute("map")
    object PIP : NavRoute("pip")
    object StartInBackground : NavRoute("start_in_background")
    object Settings : NavRoute("settings")
}