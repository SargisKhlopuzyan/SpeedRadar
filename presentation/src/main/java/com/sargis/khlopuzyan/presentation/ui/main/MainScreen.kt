package com.sargis.khlopuzyan.presentation.ui.main

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.sargis.khlopuzyan.presentation.ui.navigation.BottomNavigation
import com.sargis.khlopuzyan.presentation.ui.navigation.NavRoute
import com.sargis.khlopuzyan.presentation.ui.radar.RadarScreen
import com.sargis.khlopuzyan.presentation.ui.radar.RadarViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(
    showBottomBar: Boolean,
    onPiPCallback: () -> Unit,
) {
    val btmNavItems = listOf(
        BtmNavItem(
            route = NavRoute.Radar.route,
            selectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_radar,
            unselectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_radar_outline,
            name = "Radar"
        ),
        BtmNavItem(
            route = NavRoute.Map.route,
            selectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_map,
            unselectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_map_outline,
            name = "Map"
        ),
        BtmNavItem(
            route = NavRoute.PIP.route,
            selectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_pip,
            unselectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_pip_outline,
            name = "PiP"
        ),
        BtmNavItem(
            route = NavRoute.StartInBackground.route,
            selectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_minimize,
            unselectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_minimize_outline,
            name = "Minimize"
        ),
        BtmNavItem(
            route = NavRoute.Settings.route,
            selectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_settings,
            unselectedIcon = com.sargis.khlopuzyan.commonui.R.drawable.ic_settings_outline,
            name = "Settings"
        )
    )
    val navController = rememberNavController()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Scaffold(
        modifier = Modifier.Companion.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                val context = LocalContext.current
                MainBottomBar(
                    btmNavItems = btmNavItems,
                    currentDestination = currentDestination,
                    onNavigateToDestination = { route ->
                        when (route) {
                            NavRoute.Radar.route -> {
                                if (navController.currentBackStackEntry?.destination?.route != route) {
                                    navController.popBackStack(route, inclusive = false)
                                    navController.navigate(route) {
                                        restoreState = true
                                        launchSingleTop = true
                                    }
                                }
                            }

                            NavRoute.Map.route -> {
                                if (navController.currentBackStackEntry?.destination?.route != route) {
                                    navController.popBackStack(route, inclusive = false)
                                    navController.navigate(route) {
                                        restoreState = true
                                        launchSingleTop = true
                                    }
                                }
                            }

                            NavRoute.Settings.route -> {
                                if (navController.currentBackStackEntry?.destination?.route != route) {
                                    navController.popBackStack(route, inclusive = false)
                                    navController.navigate(route) {
                                        restoreState = true
                                        launchSingleTop = true
                                    }
                                }
                            }

                            NavRoute.PIP.route -> onPiPCallback()

                            NavRoute.StartInBackground.route -> {
                                (context as? Activity)?.moveTaskToBack(true)
                            }
                        }
                    }
                )
            } else {
                val viewModel = koinViewModel<RadarViewModel>()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                RadarScreen(
                    uiState,
                    isPiPMode = true,
                    onEvent = viewModel::onEvent
                )
            }
        }
    ) { contentPadding ->
        BottomNavigation(navController)
    }
}