package com.sargis.khlopuzyan.commonui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val colorPrimary = Color(0xFF3E6268)
val colorPrimaryDark = Color(0xFF324345)

val colorLightGrey = Color(0xFFE2E2E2)
val colorGrey = Color(0xFF707070)
val colorDarkGrey = Color(0xFF303030)

val colorLightBlack = Color(0xFF101010)
val colorBlack = Color(0xFF000000)

val colorRed = Color(0xFFFF0000)

val colorGray_7 = Color(0xFF808080)
val colorGray_9 = Color(0xFFA0A0A0)
val colorGray_11 = Color(0xFFBFBFBF)
val colorGray_13 = Color(0xFFDFDFDF)
val colorTransparent = Color(0x00FFFFFF)

val CommonUiLightColorScheme = lightColorScheme(
    primary = colorPrimary,
    onPrimary = colorLightGrey,
    primaryContainer = colorPrimary,
    onPrimaryContainer = colorLightGrey,
    inversePrimary = colorGray_7,

    secondary = colorLightGrey,
    onSecondary = colorPrimary,
    secondaryContainer = colorLightGrey,
    onSecondaryContainer = colorPrimary,

    tertiary = colorPrimary,
    onTertiary = colorLightBlack,
    tertiaryContainer = colorPrimary,
    onTertiaryContainer = colorLightBlack,

    background = colorLightGrey,
    onBackground = colorLightBlack,

    surface = colorLightGrey, // default topAppbar background color
    onSurface = colorPrimary, // default topAppbar text color
    surfaceVariant = colorLightGrey,
    onSurfaceVariant = colorGray_7,
    surfaceTint = colorGray_7,
    inverseSurface = colorGray_7,
    inverseOnSurface = colorGray_7,

    error = colorRed,
    onError = colorLightBlack,
    errorContainer = colorRed,
    onErrorContainer = colorLightBlack,

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

val CommonUiDarkColorScheme = darkColorScheme(
    primary = colorPrimaryDark,
    onPrimary = colorLightGrey,
    secondary = colorLightGrey,
    tertiary = colorGray_7,
    onTertiary = colorLightGrey
)