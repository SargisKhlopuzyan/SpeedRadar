package com.sargis.khlopuzyan.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sargis.khlopuzyan.presentation.ui.main.MainScreen
import com.sargis.khlopuzyan.presentation.ui.main.MainUiEvent
import com.sargis.khlopuzyan.presentation.ui.main.MainViewModel
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsScreen
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.MainScreen.route
    ) {
        composable(route = ScreenRoute.MainScreen.route) {
            val viewModel: MainViewModel = koinViewModel()
            MainScreen(
                navController,
                onStartObservingLocation = {
                    viewModel.onEvent(MainUiEvent.StartObservingLocation)
                },
                onNavigateSettingsScreen = {
                    navController.navigate(ScreenRoute.SettingsScreen.route)
                }
            )
        }

        composable(route = ScreenRoute.SettingsScreen.route) {
            val viewModel: SettingsViewModel = koinViewModel()
            SettingsScreen(navController)
        }
    }
}