package com.sargis.khlopuzyan.commonui.component.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.commonui.CommonUiTypography700
import com.sargis.khlopuzyan.commonui.colorGray_7

sealed class CommonUiListItemHeaderAttributes {

    abstract val height: Dp
    abstract val contentPadding: PaddingValues
    abstract val headerStyle: TextStyle
    abstract val dividerHeight: Dp
    abstract val dividerColor: Color

    data object Small : CommonUiListItemHeaderAttributes() {
        override val height = 32.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val headerStyle = CommonUiTypography700.labelSmall
        override val dividerHeight = 1.dp
        override val dividerColor = colorGray_7
    }

    data object Medium : CommonUiListItemHeaderAttributes() {
        override val height = 40.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val headerStyle = CommonUiTypography700.labelMedium
        override val dividerHeight = 1.dp
        override val dividerColor = colorGray_7
    }

    data object Large : CommonUiListItemHeaderAttributes() {
        override val height = 48.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val headerStyle = CommonUiTypography700.labelLarge
        override val dividerHeight = 1.dp
        override val dividerColor = colorGray_7
    }
}