package com.sargis.khlopuzyan.commonui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val fontLato = FontFamily(
    Font(
        resId = R.font.lato_regular,
    ),
    Font(
        resId = R.font.lato_medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resId = R.font.lato_italic,
        style = FontStyle.Italic,
    ),
    Font(
        resId = R.font.lato_thin,
        weight = FontWeight.Thin,
    ),
    Font(
        resId = R.font.lato_thin_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic,
    ),
    Font(
        resId = R.font.lato_bold,
        weight = FontWeight.Bold,
    ),
    Font(
        resId = R.font.lato_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic,
    ),
    Font(
        resId = R.font.lato_light,
        weight = FontWeight.Light,
    ),
    Font(
        resId = R.font.lato_light_italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic,
    ),
    Font(
        resId = R.font.lato_black,
        weight = FontWeight.Black,
    ),
    Font(
        resId = R.font.lato_black_italic,
        weight = FontWeight.Black,
        style = FontStyle.Italic,
    )
)

val CommonUiTypography500 = createTypography(FontWeight.W500)
val CommonUiTypography700 = createTypography(FontWeight.W700) // weight for exclusive use only (not part of the design system)
val CommonUiTypography900 = createTypography(FontWeight.W900)

private fun createTypography(fontWeight: FontWeight): Typography {
    val typography = Typography(
        headlineLarge = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 36.sp,
            lineHeight = 40.sp,
        ),

        titleSmall = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 23.sp,
            lineHeight = 25.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 25.sp,
            lineHeight = 27.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 27.sp,
            lineHeight = 29.sp,
        ),

        bodySmall = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 16.sp,
            lineHeight = 18.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 18.sp,
            lineHeight = 20.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 20.sp,
            lineHeight = 22.sp,
        ),

        labelSmall = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 18.sp,
            lineHeight = 20.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 20.sp,
            lineHeight = 22.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 22.sp,
            lineHeight = 24.sp,
        ),

        displaySmall = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 22.sp,
            lineHeight = 24.sp,
        ),
        displayMedium = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 24.sp,
            lineHeight = 26.sp,
        ),
        displayLarge = TextStyle(
            fontFamily = fontLato,
            fontWeight = fontWeight,
            fontSize = 26.sp,
            lineHeight = 28.sp,
        ),
    )
    return typography
}