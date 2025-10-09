package com.sargis.khlopuzyan.presentation.ui.main

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

@Composable
fun MainBottomBar(
    destinations: List<BtmNavItem>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (route: String) -> Unit,
) {
    NavigationBar(
//        modifier = Modifier
//            .windowInsetsPadding(
//                WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
//                WindowInsets.safeDrawing.only(WindowInsetsSides.Bottom)
//                WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
//            ),
//            .fillMaxWidth()
//            .height(70.dp),
        containerColor = Color.Transparent
    ) {
        destinations.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination.route)
                },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    Icon(
                        imageVector = ImageVector.vectorResource(icon),
                        modifier = Modifier.size(32.dp),
                        tint = Color.Unspecified,
                        contentDescription = null
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}