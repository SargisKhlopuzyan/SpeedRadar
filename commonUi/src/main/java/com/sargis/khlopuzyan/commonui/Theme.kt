package com.sargis.khlopuzyan.commonui

import android.os.Build
import androidx.compose.foundation.Indication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.commonui.component.button.CommonUiButtonAttributes

@Immutable
private data class CommonUiButtonStyle(
    val small: CommonUiButtonAttributes,
    val medium: CommonUiButtonAttributes,
    val large: CommonUiButtonAttributes,
    val dynamicButton: CommonUiButtonAttributes,
)

@Immutable
private data class CommonUiSpacing(
    val default: Dp = 16.dp,
    val extraSmall: Dp = 6.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 40.dp,
)

//private val LocalCommonUiColorScheme = staticCompositionLocalOf {
//
//}

private val LocalSpacing = staticCompositionLocalOf {
    CommonUiSpacing()
}

private val LocalCommonUiButtonStyle = staticCompositionLocalOf {
    CommonUiButtonStyle(
        small = CommonUiButtonAttributes.Small,
        medium = CommonUiButtonAttributes.Medium,
        large = CommonUiButtonAttributes.Large,
        dynamicButton = CommonUiButtonAttributes.DynamicButton(),
    )
}

val CommonUiTextSelectionColors = TextSelectionColors(
    handleColor = colorPrimary,
    backgroundColor = colorTransparent,
)

private object NoRipple : Indication/*, IndicationInstance*/ {
//    @Composable
//    override fun rememberUpdatedInstance(interactionSource: InteractionSource) = this
//    override fun ContentDrawScope.drawIndication() = drawContent()
}

@Composable
fun CommonUiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    typography: Typography = CommonUiTypography500,
    content: @Composable () -> Unit,
) {
    val replacementButtonStyle = CommonUiButtonStyle(
        small = CommonUiButtonAttributes.Small,
        medium = CommonUiButtonAttributes.Medium,
        large = CommonUiButtonAttributes.Large,
        dynamicButton = CommonUiButtonAttributes.DynamicButton(),
    )

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> CommonUiDarkColorScheme
        else -> CommonUiLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = {
            CompositionLocalProvider(
//                LocalIndication provides NoRipple,
                LocalCommonUiButtonStyle provides replacementButtonStyle,
                LocalTextSelectionColors provides CommonUiTextSelectionColors,
                LocalSpacing provides CommonUiSpacing(),
                content = content,
            )
        }
    )
}