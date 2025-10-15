package com.sargis.khlopuzyan.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sargis.khlopuzyan.presentation.ui.map.MapScreen
import com.sargis.khlopuzyan.presentation.ui.map.MapViewModel
import com.sargis.khlopuzyan.presentation.ui.radar.RadarScreen
import com.sargis.khlopuzyan.presentation.ui.radar.RadarViewModel
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsScreen
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BottomNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Radar.route) {
        composable(route = NavRoute.Radar.route) {
            val viewModel = koinViewModel<RadarViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            RadarScreen(
                uiState,
                onEvent = viewModel::onEvent
            )
        }
        composable(route = NavRoute.Map.route) {
            val viewModel = koinViewModel<MapViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            MapScreen(
                uiState,
                onEvent = viewModel::onEvent
            )
        }
        composable(route = NavRoute.Settings.route) {
            val viewModel = koinViewModel<SettingsViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            SettingsScreen(uiState)
        }
    }
}