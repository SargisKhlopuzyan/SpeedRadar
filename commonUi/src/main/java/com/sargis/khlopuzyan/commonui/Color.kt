package com.sargis.khlopuzyan.commonui

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

val colorBlack = Color(0xFF000000)
val colorGray_1 = Color(0xFF101010)
val colorGray_2 = Color(0xFF303030)
val colorGray_3 = Color(0xFF404040)
val colorGray_4 = Color(0xFF505050)
val colorGray_5 = Color(0xFF606060)
val colorGray_6 = Color(0xFF707070)
val colorGray_7 = Color(0xFF808080)
val colorGray_8 = Color(0xFF909090)
val colorGray_9 = Color(0xFFA0A0A0)
val colorGray_10 = Color(0xFFAFAFAF)
val colorGray_11 = Color(0xFFBFBFBF)
val colorGray_12 = Color(0xFFCFCFCF)
val colorGray_13 = Color(0xFFDFDFDF)
val colorGray_14 = Color(0xFFEFEFEF)
val colorWhite = Color(0xFFFFFFFF)
val colorTransparent = Color(0x00FFFFFF)

val commonUiColorScheme = ColorScheme(
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