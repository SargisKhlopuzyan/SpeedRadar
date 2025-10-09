package com.sargis.khlopuzyan.commonui.component.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.commonui.CommonUiTypography500
import com.sargis.khlopuzyan.commonui.colorGray_7

sealed class CommonUiListItemAttributes {

    abstract val height: Dp
    abstract val contentPadding: PaddingValues
    abstract val titleStyle: TextStyle
    abstract val contentStyle: TextStyle
    abstract val leftIconSize: Dp
    abstract val rightIconSize: Dp
    abstract val spaceBetweenIconAndText: Dp
    abstract val dividerHeight: Dp
    abstract val dividerColor: Color
    abstract val borderStrokeWidth: Dp

    data object Small : CommonUiListItemAttributes() {
        override val height = 44.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val titleStyle = CommonUiTypography500.bodySmall
        override val contentStyle = CommonUiTypography500.bodySmall
        override val leftIconSize = 22.dp
        override val rightIconSize = 22.dp
        override val spaceBetweenIconAndText = 16.dp
        override val dividerHeight = 1.dp
        override val dividerColor = colorGray_7
        override val borderStrokeWidth = 2.dp
    }

    data object Medium : CommonUiListItemAttributes() {
        override val height = 52.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val titleStyle = CommonUiTypography500.bodyMedium
        override val contentStyle = CommonUiTypography500.bodyMedium
        override val leftIconSize = 28.dp
        override val rightIconSize = 28.dp
        override val spaceBetweenIconAndText = 16.dp
        override val dividerHeight = 1.dp
        override val dividerColor = colorGray_7
        override val borderStrokeWidth = 2.dp
    }

    data object Large : CommonUiListItemAttributes() {
        override val height = 64.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val titleStyle = CommonUiTypography500.bodyLarge
        override val contentStyle = CommonUiTypography500.bodyLarge
        override val leftIconSize = 28.dp
        override val rightIconSize = 28.dp
        override val spaceBetweenIconAndText = 16.dp
        override val dividerHeight = 1.dp
        override val dividerColor = colorGray_7
        override val borderStrokeWidth = 2.dp
    }
}