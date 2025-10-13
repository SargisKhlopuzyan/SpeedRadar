package com.sargis.khlopuzyan.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sargis.khlopuzyan.presentation.ui.map.MapScreen
import com.sargis.khlopuzyan.presentation.ui.radar.RadarScreen
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsScreen

@Composable
fun BottomNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Radar.route) {
        composable(route = NavRoute.Radar.route) {
            RadarScreen(
                navController,
                onStartObservingLocation = {}
            )
        }
        composable(route = NavRoute.Map.route) {
            MapScreen(
                navController,
                onStartObservingLocation = {}
            )
        }
        composable(route = NavRoute.Settings.route) {
            SettingsScreen(navController)
        }
    }
}