package com.sargis.khlopuzyan.presentation.ui.radar

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale
import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.commonui.component.appBar.CommonTopAppBar
import com.sargis.khlopuzyan.commonui.component.button.CommonUiPrimaryButton
import com.sargis.khlopuzyan.presentation.R
import com.sargis.khlopuzyan.presentation.util.isPermanentlyDenied

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RadarScreen(
    navController: NavController,
    isPiPMode: Boolean = false,
    onStartObservingLocation: () -> Unit,
) {
    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver() { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                permissionsState.launchMultiplePermissionRequest()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (!isPiPMode) {
                CommonTopAppBar(
                    title = stringResource(R.string.radar)
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            permissionsState.permissions.forEach { perm ->
                when (perm.permission) {
                    Manifest.permission.ACCESS_FINE_LOCATION -> {
                        when {
                            perm.status.isGranted -> {
                                Text(
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    text = "Fine Location permission accepted"
                                )
                            }

                            perm.status.shouldShowRationale -> {
                                Text(
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    text = "Fine Location permission needed"
                                )
                            }

                            perm.isPermanentlyDenied() -> {
                                Text(
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    text = "Fine Location permission is permanently denied. You can enable it in app settings"
                                )
                            }
                        }
                    }

                    Manifest.permission.ACCESS_COARSE_LOCATION -> {
                        when {
                            perm.status.isGranted -> {
                                Text(
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    text = "Coarse Location permission accepted"
                                )

                                CommonUiPrimaryButton(
                                    text = "Start observing location",
                                    onClick = {
                                        onStartObservingLocation()
                                    }
                                )
                            }

                            perm.status.shouldShowRationale -> {
                                Text("Coarse Location permission needed")
                            }

                            perm.isPermanentlyDenied() -> {
                                Text("Record audio permission is permanently denied. You can enable it in app settings")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadarScreenPreview() {
    CommonUiTheme {
        val navController = rememberNavController()
        RadarScreen(
            navController = navController,
            onStartObservingLocation = {},
        )
    }
}