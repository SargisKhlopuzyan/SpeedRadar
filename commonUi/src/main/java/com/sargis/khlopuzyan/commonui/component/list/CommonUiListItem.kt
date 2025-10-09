package com.sargis.khlopuzyan.commonui.component.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.commonui.R

@Composable
private fun CommonUiListItem(
    modifier: Modifier = Modifier,

    title: String,
    titleMaxLines: Int = 1,
    titleOverflow: TextOverflow = TextOverflow.Ellipsis,
    titleLetterSpacing: TextUnit = 0.sp,

    content: String? = null,
    contentMaxLines: Int = 2,
    contentOverflow: TextOverflow = TextOverflow.Ellipsis,
    contentLetterSpacing: TextUnit = 0.sp,

    @DrawableRes leftIconResId: Int? = null,
    leftImageVector: ImageVector? = null,
    leftIconTint: Color = Color.Unspecified,
    leftIconContentDescription: String = "",

    @DrawableRes rightIconResId: Int? = null,
    rightImageVector: ImageVector? = null,
    rightIconTint: Color = Color.Unspecified,
    rightIconContentDescription: String = "",

    enabled: Boolean = true,
    showDivider: Boolean = false,

    attributes: CommonUiListItemAttributes = CommonUiListItemAttributes.Medium,
    onClick: () -> Unit = {},
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
            .clickable(
                enabled = enabled,
//                indication = rememberRipple(), // Or null if no ripple is desired
//                interactionSource = remember { MutableInteractionSource() }
            ) {
                onClick()
            }
            .padding(attributes.contentPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when {
            leftIconResId != null -> {
                Icon(
                    modifier = Modifier.size(attributes.leftIconSize),
                    painter = painterResource(id = leftIconResId),
                    tint = leftIconTint,
                    contentDescription = leftIconContentDescription,
                )
            }

            leftImageVector != null -> {
                Icon(
                    modifier = Modifier.size(attributes.leftIconSize),
                    imageVector = leftImageVector,
                    tint = leftIconTint,
                    contentDescription = leftIconContentDescription,
                )
            }
        }

        if (leftIconResId != null || leftImageVector != null) {
            Spacer(modifier = Modifier.width(attributes.spaceBetweenIconAndText))
        }

        if (content != null) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    color = MaterialTheme.colorScheme.onTertiary,
                    style = attributes.titleStyle,
                    textAlign = TextAlign.Start,
                    maxLines = titleMaxLines,
                    overflow = titleOverflow,
                    letterSpacing = titleLetterSpacing,
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = content,
                    color = MaterialTheme.colorScheme.onTertiary,
                    style = attributes.contentStyle,
                    textAlign = TextAlign.Start,
                    maxLines = contentMaxLines,
                    overflow = contentOverflow,
                    letterSpacing = contentLetterSpacing,
                )
            }
        } else {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                color = MaterialTheme.colorScheme.onTertiary,
                style = attributes.titleStyle,
                textAlign = TextAlign.Start,
                maxLines = titleMaxLines,
                overflow = titleOverflow,
                letterSpacing = titleLetterSpacing,
            )
        }

        if (rightIconResId != null || rightImageVector != null) {
            Spacer(modifier = Modifier.width(attributes.spaceBetweenIconAndText))
        }

        when {
            rightIconResId != null -> {
                Icon(
                    modifier = Modifier.size(attributes.leftIconSize),
                    painter = painterResource(id = rightIconResId),
                    tint = rightIconTint,
                    contentDescription = rightIconContentDescription,
                )
            }

            rightImageVector != null -> {
                Icon(
                    modifier = Modifier.size(attributes.leftIconSize),
                    imageVector = rightImageVector,
                    tint = rightIconTint,
                    contentDescription = rightIconContentDescription,
                )
            }
        }
    }
}

@Composable
fun CommonUiListItemSmall(
    modifier: Modifier = Modifier,

    title: String,
    titleMaxLines: Int = 1,
    titleOverflow: TextOverflow = TextOverflow.Ellipsis,
    titleLetterSpacing: TextUnit = 0.sp,

    content: String? = null,
    contentMaxLines: Int = 2,
    contentOverflow: TextOverflow = TextOverflow.Ellipsis,
    contentLetterSpacing: TextUnit = 0.sp,

    @DrawableRes leftIconResId: Int? = null,
    leftImageVector: ImageVector? = null,
    leftIconTint: Color = Color.Unspecified,
    leftIconContentDescription: String = "",

    @DrawableRes rightIconResId: Int? = null,
    rightImageVector: ImageVector? = null,
    rightIconTint: Color = Color.Unspecified,
    rightIconContentDescription: String = "",

    enabled: Boolean = true,
    showDivider: Boolean = false,

    onClick: () -> Unit = {},
) {
    CommonUiListItem(
        modifier = modifier,

        title = title,
        titleMaxLines = titleMaxLines,
        titleOverflow = titleOverflow,
        titleLetterSpacing = titleLetterSpacing,

        content = content,
        contentMaxLines = contentMaxLines,
        contentOverflow = contentOverflow,
        contentLetterSpacing = contentLetterSpacing,

        leftIconResId = leftIconResId,
        leftImageVector = leftImageVector,
        leftIconTint = leftIconTint,
        leftIconContentDescription = leftIconContentDescription,

        rightIconResId = rightIconResId,
        rightImageVector = rightImageVector,
        rightIconTint = rightIconTint,
        rightIconContentDescription = rightIconContentDescription,

        enabled = enabled,
        showDivider = showDivider,

        attributes = CommonUiListItemAttributes.Small,
        onClick = onClick
    )
}

@Composable
fun CommonUiListItemMedium(
    modifier: Modifier = Modifier,

    title: String,
    titleMaxLines: Int = 1,
    titleOverflow: TextOverflow = TextOverflow.Ellipsis,
    titleLetterSpacing: TextUnit = 0.sp,

    content: String? = null,
    contentMaxLines: Int = 2,
    contentOverflow: TextOverflow = TextOverflow.Ellipsis,
    contentLetterSpacing: TextUnit = 0.sp,

    @DrawableRes leftIconResId: Int? = null,
    leftImageVector: ImageVector? = null,
    leftIconTint: Color = Color.Unspecified,
    leftIconContentDescription: String = "",

    @DrawableRes rightIconResId: Int? = null,
    rightImageVector: ImageVector? = null,
    rightIconTint: Color = Color.Unspecified,
    rightIconContentDescription: String = "",

    enabled: Boolean = true,
    showDivider: Boolean = false,

    onClick: () -> Unit = {},
) {
    CommonUiListItem(
        modifier = modifier,

        title = title,
        titleMaxLines = titleMaxLines,
        titleOverflow = titleOverflow,
        titleLetterSpacing = titleLetterSpacing,

        content = content,
        contentMaxLines = contentMaxLines,
        contentOverflow = contentOverflow,
        contentLetterSpacing = contentLetterSpacing,

        leftIconResId = leftIconResId,
        leftImageVector = leftImageVector,
        leftIconTint = leftIconTint,
        leftIconContentDescription = leftIconContentDescription,

        rightIconResId = rightIconResId,
        rightImageVector = rightImageVector,
        rightIconTint = rightIconTint,
        rightIconContentDescription = rightIconContentDescription,

        enabled = enabled,
        showDivider = showDivider,

        attributes = CommonUiListItemAttributes.Medium,
        onClick = onClick
    )
}

@Composable
fun CommonUiListItemLarge(
    modifier: Modifier = Modifier,

    title: String,
    titleMaxLines: Int = 1,
    titleOverflow: TextOverflow = TextOverflow.Ellipsis,
    titleLetterSpacing: TextUnit = 0.sp,

    content: String? = null,
    contentMaxLines: Int = 2,
    contentOverflow: TextOverflow = TextOverflow.Ellipsis,
    contentLetterSpacing: TextUnit = 0.sp,

    @DrawableRes leftIconResId: Int? = null,
    leftImageVector: ImageVector? = null,
    leftIconTint: Color = Color.Unspecified,
    leftIconContentDescription: String = "",

    @DrawableRes rightIconResId: Int? = null,
    rightImageVector: ImageVector? = null,
    rightIconTint: Color = Color.Unspecified,
    rightIconContentDescription: String = "",

    enabled: Boolean = true,
    showDivider: Boolean = false,

    onClick: () -> Unit = {},
) {
    CommonUiListItem(
        modifier = modifier,

        title = title,
        titleMaxLines = titleMaxLines,
        titleOverflow = titleOverflow,
        titleLetterSpacing = titleLetterSpacing,

        content = content,
        contentMaxLines = contentMaxLines,
        contentOverflow = contentOverflow,
        contentLetterSpacing = contentLetterSpacing,

        leftIconResId = leftIconResId,
        leftImageVector = leftImageVector,
        leftIconTint = leftIconTint,
        leftIconContentDescription = leftIconContentDescription,

        rightIconResId = rightIconResId,
        rightImageVector = rightImageVector,
        rightIconTint = rightIconTint,
        rightIconContentDescription = rightIconContentDescription,

        enabled = enabled,
        showDivider = showDivider,

        attributes = CommonUiListItemAttributes.Large,
        onClick = onClick
    )
}

@Composable
@Preview
private fun CommonUiListItemsPreviews() {
    CommonUiTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            CommonUiListItemSmall(
                title = "Title\ntitle2\ntitle3".uppercase(),
                showDivider = true
            )

            CommonUiListItemSmall(
                title = "Title\ntitle2\ntitle3".uppercase(),
                content = "Content\ncontent2\ncontent3".uppercase(),
                showDivider = true
            )

            CommonUiListItemSmall(
                title = "Title\ntitle2\ntitle3".uppercase(),
                content = "Content\ncontent2\ncontent3".uppercase(),
                leftIconResId = R.drawable.ic_info_circle,
                rightIconResId = R.drawable.ic_info_circle,
                showDivider = true
            )

            CommonUiListItemMedium(
                title = "Title\ntitle2\ntitle3".uppercase(),
                showDivider = true
            )

            CommonUiListItemMedium(
                title = "Title\ntitle2\ntitle3".uppercase(),
                content = "Content\ncontent2\ncontent3".uppercase(),
                showDivider = true
            )

            CommonUiListItemMedium(
                title = "Title\ntitle2\ntitle3".uppercase(),
                content = "Content\ncontent2\ncontent3".uppercase(),
                leftIconResId = R.drawable.ic_info_circle,
                rightIconResId = R.drawable.ic_info_circle,
                showDivider = true
            )

            CommonUiListItemLarge(
                title = "Title\ntitle2\ntitle3".uppercase(),
                showDivider = true
            )

            CommonUiListItemLarge(
                title = "Title\ntitle2\ntitle3".uppercase(),
                content = "Content\ncontent2\ncontent3".uppercase(),
                showDivider = true
            )

            CommonUiListItemLarge(
                title = "Title\ntitle2\ntitle3".uppercase(),
                content = "Content\ncontent2\ncontent3".uppercase(),
                leftIconResId = R.drawable.flag_am,
                rightIconResId = R.drawable.ic_info_circle,
                showDivider = true
            )
        }
    }
}
