package com.sargis.khlopuzyan.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.presentation.ui.navigation.Navigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CommonUiTheme {
                Navigation()
            }
        }
    }
}