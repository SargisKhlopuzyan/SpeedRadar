package com.sargis.khlopuzyan.presentation

import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.util.Rational
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.window.layout.WindowMetricsCalculator
import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.presentation.ui.navigation.Navigation


class MainActivity : ComponentActivity() {

    private val isPipSupported by lazy {
        packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
    }

    val viewBounds by lazy {
        WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this).bounds
    }

    class PiPReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            println("Clicked on PIP action")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (pipMode == PipMode.MODE_FULL) {
            saveDpi()
        } else {
            setDpi()
        }

        enableEdgeToEdge()
        setContent {
            CommonUiTheme {
                Navigation(
                    showBottomBar = pipMode != PipMode.MODE_PIP,
                    onPiPCallback = {
                        showInPipMode()
                    }
                )
            }
        }
    }

    private fun updatedPipParams(): PictureInPictureParams? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PictureInPictureParams
                .Builder()
                .setSourceRectHint(viewBounds)
//                .setAspectRatio(Rational(16, 9))
                .setAspectRatio(Rational(1, 1))
                .setActions(
                    listOf(
                        RemoteAction(
                            Icon.createWithResource(
                                applicationContext,
                                com.sargis.khlopuzyan.commonui.R.drawable.ic_info_circle
                            ),
                            getString(R.string.map),
                            getString(R.string.map),
                            PendingIntent.getBroadcast(
                                applicationContext,
                                0,
                                Intent(applicationContext, PiPReceiver::class.java),
                                PendingIntent.FLAG_IMMUTABLE
                            )
                        )
                    )
                )
                .run {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        setSeamlessResizeEnabled(true)
                    } else {
                        this
                    }
                }
                .run {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        setExpandedAspectRatio(Rational(1, 1))
                    } else {
                        this
                    }
                }
                .build()
        } else {
            null
        }
    }

    private fun showInPipMode() {
        if (!isPipSupported) return
        updatedPipParams()?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                enterPictureInPictureMode(it)
            }
        }
    }

    var pipMode by mutableStateOf(PipMode.MODE_FULL)

    var orgDensityDpi: Int = 0

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration,
    ) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        pipMode = if (isInPictureInPictureMode)
            PipMode.MODE_PIP
        else
            PipMode.MODE_FULL
    }

    private fun saveDpi() {
        val configuration: Configuration = resources.configuration
        orgDensityDpi = configuration.densityDpi
    }

    private fun setDpi() {
        val configuration = resources.configuration
        val metrics = resources.displayMetrics
        if (pipMode === PipMode.MODE_PIP) {
            configuration.densityDpi = orgDensityDpi / 3
        } else {
            configuration.densityDpi = orgDensityDpi
        }
        baseContext.resources.updateConfiguration(configuration, metrics)
    }
}

enum class PipMode {
    //    MODE_NONE,
    MODE_FULL,
    MODE_PIP
}