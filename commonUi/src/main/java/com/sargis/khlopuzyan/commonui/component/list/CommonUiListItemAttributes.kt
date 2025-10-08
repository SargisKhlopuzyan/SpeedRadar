package com.sargis.khlopuzyan.commonui.component.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.commonui.CommonUiTypography700
import com.sargis.khlopuzyan.commonui.CommonUiTypography900

sealed class CommonUiListItemAttributes {

    abstract val height: Dp
    abstract val contentPadding: PaddingValues
    abstract val cornerRadius: Dp
    abstract val titleStyle: TextStyle
    abstract val contentStyle: TextStyle
    abstract val iconSize: Dp
    abstract val spaceBetweenIconAndText: Dp
    abstract val borderStrokeWidth: Dp

    data object Small : CommonUiListItemAttributes() {
//        override val height = 36.dp
        override val height = 48.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val cornerRadius = 14.dp
        override val titleStyle = CommonUiTypography900.bodySmall
        override val contentStyle = CommonUiTypography900.bodySmall
        override val iconSize = 22.dp
        override val spaceBetweenIconAndText = 6.dp
        override val borderStrokeWidth = 2.dp
    }

    data object Medium : CommonUiListItemAttributes() {
//        override val height = 48.dp
        override val height = 56.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val cornerRadius = 18.dp
        override val titleStyle = CommonUiTypography700.bodyMedium
        override val contentStyle = CommonUiTypography700.bodyMedium
        override val iconSize = 28.dp
        override val spaceBetweenIconAndText = 8.dp
        override val borderStrokeWidth = 2.dp
    }

    data object Large : CommonUiListItemAttributes() {
//        override val height = 56.dp
        override val height = 64.dp
        override val contentPadding = PaddingValues(horizontal = 16.dp)
        override val cornerRadius = 18.dp
        override val titleStyle = CommonUiTypography700.bodyLarge
        override val contentStyle = CommonUiTypography700.bodyLarge
        override val iconSize = 28.dp
        override val spaceBetweenIconAndText = 8.dp
        override val borderStrokeWidth = 2.dp
    }

    data class DynamicListItem(
        override val height: Dp = 40.dp,
        override val contentPadding: PaddingValues = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp,
        ),
        override val cornerRadius: Dp = 16.dp,
        override val titleStyle: TextStyle = CommonUiTypography700.bodyMedium,
        override val contentStyle: TextStyle = CommonUiTypography700.bodyMedium,
        override val iconSize: Dp = 19.dp,
        override val spaceBetweenIconAndText: Dp = 6.8.dp,
        override val borderStrokeWidth: Dp = 2.dp,
    ) : CommonUiListItemAttributes()
}