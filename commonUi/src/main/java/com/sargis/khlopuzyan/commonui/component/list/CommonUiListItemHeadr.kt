package com.sargis.khlopuzyan.commonui.component.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sargis.khlopuzyan.commonui.CommonUiTheme

@Composable
private fun CommonUiListItemHeader(
    modifier: Modifier = Modifier,
    header: String,
    headerMaxLines: Int = 1,
    headerOverflow: TextOverflow = TextOverflow.Ellipsis,
    headerLetterSpacing: TextUnit = 0.sp,
    showDivider: Boolean = false,
    attributes: CommonUiListItemHeaderAttributes = CommonUiListItemHeaderAttributes.Medium,
) {
    Row(
        modifier = modifier
            .height(attributes.height)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .run {
                if (showDivider) {
                    drawBehind {
                        val borderWidthPx = with(density) { attributes.dividerHeight.toPx() }
                        drawLine(
                            color = attributes.dividerColor,
                            start = Offset(0f, size.height - borderWidthPx), // Start at bottom left
                            end = Offset(
                                size.width,
                                size.height - borderWidthPx
                            ), // End at bottom right
                            strokeWidth = borderWidthPx
                        )
                    }
                } else this

            }
            .padding(attributes.contentPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = header,
            color = MaterialTheme.colorScheme.primary,
            style = attributes.headerStyle,
            textAlign = TextAlign.Start,
            maxLines = headerMaxLines,
            overflow = headerOverflow,
            letterSpacing = headerLetterSpacing,
        )
    }
}

@Composable
fun CommonUiListItemHeaderSmall(
    modifier: Modifier = Modifier,
    header: String,
    headerMaxLines: Int = 1,
    headerOverflow: TextOverflow = TextOverflow.Ellipsis,
    headerLetterSpacing: TextUnit = 0.sp,
    showDivider: Boolean = false,
) {
    CommonUiListItemHeader(
        modifier = modifier,
        header = header,
        headerMaxLines = headerMaxLines,
        headerOverflow = headerOverflow,
        headerLetterSpacing = headerLetterSpacing,
        showDivider = showDivider,
        attributes = CommonUiListItemHeaderAttributes.Small,
    )
}

@Composable
fun CommonUiListItemHeaderMedium(
    modifier: Modifier = Modifier,
    header: String,
    headerMaxLines: Int = 1,
    headerOverflow: TextOverflow = TextOverflow.Ellipsis,
    headerLetterSpacing: TextUnit = 0.sp,
    showDivider: Boolean = false,
) {
    CommonUiListItemHeader(
        modifier = modifier,
        header = header,
        headerMaxLines = headerMaxLines,
        headerOverflow = headerOverflow,
        headerLetterSpacing = headerLetterSpacing,
        showDivider = showDivider,
        attributes = CommonUiListItemHeaderAttributes.Medium,
    )
}

@Composable
fun CommonUiListItemHeaderLarge(
    modifier: Modifier = Modifier,
    header: String,
    headerMaxLines: Int = 1,
    headerOverflow: TextOverflow = TextOverflow.Ellipsis,
    headerLetterSpacing: TextUnit = 0.sp,
    showDivider: Boolean = false,
) {
    CommonUiListItemHeader(
        modifier = modifier,
        header = header,
        headerMaxLines = headerMaxLines,
        headerOverflow = headerOverflow,
        headerLetterSpacing = headerLetterSpacing,
        showDivider = showDivider,
        attributes = CommonUiListItemHeaderAttributes.Large,
    )
}

@Composable
@Preview
private fun CommonUiListItemsPreviews() {
    CommonUiTheme {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CommonUiListItemHeaderSmall(
                header = "Title\ntitle2\ntitle3".uppercase(),
                showDivider = true
            )

            CommonUiListItemHeaderMedium(
                header = "Title\ntitle2\ntitle3".uppercase(),
                showDivider = true
            )

            CommonUiListItemHeaderLarge(
                header = "Title\ntitle2\ntitle3".uppercase(),
            )
        }
    }
}
