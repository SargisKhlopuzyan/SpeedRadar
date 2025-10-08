package com.sargis.khlopuzyan.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.sargis.khlopuzyan.commonui.colorBlack
import com.sargis.khlopuzyan.commonui.colorGray_12
import com.sargis.khlopuzyan.commonui.colorGray_7
import com.sargis.khlopuzyan.commonui.colorTransparent
import com.sargis.khlopuzyan.commonui.colorWhite
import com.sargis.khlopuzyan.commonui.component.button.CommonUiButtonAttributes

@Immutable
data class CommonUiButtonStyle(
    val small: CommonUiButtonAttributes,
    val medium: CommonUiButtonAttributes,
    val large: CommonUiButtonAttributes,
    val dynamicButton: CommonUiButtonAttributes,
)

val LocalCommonUiButtonStyle = staticCompositionLocalOf {
    CommonUiButtonStyle(
        small = CommonUiButtonAttributes.Small,
        medium = CommonUiButtonAttributes.Medium,
        large = CommonUiButtonAttributes.Large,
        dynamicButton = CommonUiButtonAttributes.DynamicButton(),
    )
}

val CommonUiTextSelectionColors = TextSelectionColors(
    handleColor = colorBlack,
    backgroundColor = colorTransparent,
)

private object NoRipple : Indication/*, IndicationInstance*/ {
//    @Composable
//    override fun rememberUpdatedInstance(interactionSource: InteractionSource) = this
//    override fun ContentDrawScope.drawIndication() = drawContent()
}

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */

    primary = colorBlack,
    onPrimary = colorWhite,
    primaryContainer = colorWhite,
    onPrimaryContainer = colorBlack,
    inversePrimary = colorGray_7,

    secondary = colorWhite,
    onSecondary = colorBlack,
    secondaryContainer = colorWhite,
    onSecondaryContainer = colorBlack,

    tertiary = colorGray_7,
    onTertiary = colorGray_7,
    tertiaryContainer = colorGray_7,
    onTertiaryContainer = colorGray_7,

    background = colorGray_12,
    onBackground = colorBlack,

    surface = colorWhite,
    onSurface = colorBlack,
    surfaceVariant = colorWhite,
    onSurfaceVariant = colorGray_7,
    surfaceTint = colorGray_7,
    inverseSurface = colorGray_7,
    inverseOnSurface = colorGray_7,

    error = colorBlack,
    onError = colorBlack,
    errorContainer = colorGray_7,
    onErrorContainer = colorGray_7,

    outline = colorGray_7,
    outlineVariant = colorGray_7,

    scrim = colorGray_7,

    surfaceBright = colorGray_7,
    surfaceDim = colorGray_7,
    surfaceContainer = colorGray_7,
    surfaceContainerHigh = colorGray_7,
    surfaceContainerHighest = colorGray_7,
    surfaceContainerLow = colorGray_7,
    surfaceContainerLowest = colorGray_7
)

@Composable
fun SpeedRadarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = {
            CompositionLocalProvider(
                LocalIndication provides NoRipple,
                LocalCommonUiButtonStyle provides replacementButtonStyle,
                LocalTextSelectionColors provides CommonUiTextSelectionColors,
                content = content,
            )
        }
    )
}