package com.sargis.khlopuzyan.presentation.ui.main

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.sargis.khlopuzyan.presentation.ui.map.MapScreen
import com.sargis.khlopuzyan.presentation.ui.navigation.BottomNavigation
import com.sargis.khlopuzyan.presentation.ui.navigation.NavRoute
import com.sargis.khlopuzyan.presentation.ui.radar.RadarScreen
import com.sargis.khlopuzyan.presentation.ui.settings.SettingsScreen

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(
    navController: NavController,
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
    Scaffold(
        modifier = Modifier.Companion.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                val context = LocalContext.current
                MainBottomBar(
                    destinations = btmNavItems,
                    currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                    onNavigateToDestination = {
                        when (it) {
                            NavRoute.Radar.route -> {
                                navController.navigate(it) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    restoreState = true
                                    launchSingleTop = true
                                }
                            }

                            NavRoute.Map.route -> {
                                navController.navigate(it) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    restoreState = true
                                    launchSingleTop = true
                                }
                            }

                            NavRoute.Settings.route -> {
                                navController.navigate(it) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    restoreState = true
                                    launchSingleTop = true
                                }
                            }

                            NavRoute.PIP.route -> onPiPCallback()

                            NavRoute.StartInBackground.route -> {
                                (context as? Activity)?.moveTaskToBack(true)
                            }
                        }
                    }
                )
            }
        }
    ) { contentPadding ->
        BottomNavigation(navController)
    }
}