package com.sargis.khlopuzyan.commonui

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.sargis.khlopuzyan.commonui.component.button.CommonUiButtonAttributes

@Immutable
private data class CommonUiButtonStyle(
    val small: CommonUiButtonAttributes,
    val medium: CommonUiButtonAttributes,
    val large: CommonUiButtonAttributes,
    val dynamicButton: CommonUiButtonAttributes,
)

private val LocalCommonUiButtonStyle = staticCompositionLocalOf {
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

@Composable
fun CommonUiTheme(
    colorScheme: ColorScheme = commonUiColorScheme,
    typography: Typography = CommonUiTypography500,
    content: @Composable () -> Unit,
) {
    val replacementButtonStyle = CommonUiButtonStyle(
        small = CommonUiButtonAttributes.Small,
        medium = CommonUiButtonAttributes.Medium,
        large = CommonUiButtonAttributes.Large,
        dynamicButton = CommonUiButtonAttributes.DynamicButton(),
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = {
            CompositionLocalProvider(
                LocalIndication provides NoRipple,
                LocalCommonUiButtonStyle provides replacementButtonStyle,
                LocalTextSelectionColors provides CommonUiTextSelectionColors,
                content = content,
            )
        },
    )
}