package com.sargis.khlopuzyan.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sargis.khlopuzyan.presentation.ui.main.MainScreen
import com.sargis.khlopuzyan.presentation.ui.main.MainViewModel
import com.sargis.khlopuzyan.presentation.ui.map.MapScreen
import com.sargis.khlopuzyan.presentation.ui.map.MapUiEvent
import com.sargis.khlopuzyan.presentation.ui.map.MapViewModel
import com.sargis.khlopuzyan.presentation.ui.radar.RadarScreen
import com.sargis.khlopuzyan.presentation.ui.radar.RadarUiEvent
import com.sargis.khlopuzyan.presentation.ui.radar.RadarViewModel
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsScreen
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation(
    showBottomBar: Boolean,
    onPiPCallback: () -> Unit,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoute.Main.route
    ) {
        composable(route = NavRoute.Main.route) {
            val viewModel: MainViewModel = koinViewModel()
            MainScreen(
                navController,
                showBottomBar,
                onPiPCallback = onPiPCallback
            )
        }

        composable(route = NavRoute.Radar.route) {
            val viewModel: RadarViewModel = koinViewModel()
            RadarScreen(
                navController,
                onStartObservingLocation = {
                    viewModel.onEvent(RadarUiEvent.StartObservingLocation)
                },
            )
        }

        composable(route = NavRoute.Map.route) {
            val viewModel: MapViewModel = koinViewModel()
            MapScreen(
                navController,
                onStartObservingLocation = {
                    viewModel.onEvent(MapUiEvent.StartObservingLocation)
                },
            )
        }

        composable(route = NavRoute.Settings.route) {
            val viewModel: SettingsViewModel = koinViewModel()
            SettingsScreen(navController)
        }
    }
}