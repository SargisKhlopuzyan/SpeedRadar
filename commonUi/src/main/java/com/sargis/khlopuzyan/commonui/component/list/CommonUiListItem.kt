package com.sargis.khlopuzyan.commonui.component.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sargis.khlopuzyan.commonui.CommonUiTypography900
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
    border: BorderStroke? = null,
    attributes: CommonUiListItemAttributes = CommonUiListItemAttributes.Medium,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .height(attributes.height)
            .padding(attributes.contentPadding)
            .also { m ->
                border?.let {
                    m.border(border)
                }
                if (enabled) {
                    m.clickable {
                        onClick()
                    }
                }
            },
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        when {
            leftIconResId != null -> {
                Icon(
                    modifier = Modifier.size(attributes.iconSize),
                    painter = painterResource(id = leftIconResId),
                    tint = if (leftIconTint != Color.Unspecified) leftIconTint else LocalContentColor.current,
                    contentDescription = leftIconContentDescription,
                )
            }

            leftImageVector != null -> {
                Icon(
                    modifier = Modifier.size(attributes.iconSize),
                    imageVector = leftImageVector,
                    tint = if (leftIconTint != Color.Unspecified) leftIconTint else LocalContentColor.current,
                    contentDescription = leftIconContentDescription,
                )
            }
        }

        if (leftIconResId != null || leftImageVector != null) {
            Spacer(modifier = Modifier.width(attributes.spaceBetweenIconAndText))
        }

        if (content != null) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = attributes.titleStyle,
                    textAlign = TextAlign.Start,
                    maxLines = titleMaxLines,
                    overflow = titleOverflow,
                    letterSpacing = titleLetterSpacing,
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = content,
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
                    modifier = Modifier.size(attributes.iconSize),
                    painter = painterResource(id = rightIconResId),
                    tint = if (rightIconTint != Color.Unspecified) rightIconTint else LocalContentColor.current,
                    contentDescription = rightIconContentDescription,
                )
            }

            rightImageVector != null -> {
                Icon(
                    modifier = Modifier.size(attributes.iconSize),
                    imageVector = rightImageVector,
                    tint = if (rightIconTint != Color.Unspecified) rightIconTint else LocalContentColor.current,
                    contentDescription = rightIconContentDescription,
                )
            }
        }
    }
}

@Composable
fun CommonUiListItemSmall(
    modifier: Modifier = Modifier.fillMaxWidth(),

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
    border: BorderStroke? = null,
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
        border = border,
        attributes = CommonUiListItemAttributes.Small,
        onClick = onClick
    )
}

@Composable
fun CommonUiListItemMedium(
    modifier: Modifier = Modifier.fillMaxWidth(),

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
    border: BorderStroke? = null,
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
        border = border,
        attributes = CommonUiListItemAttributes.Medium,
        onClick = onClick
    )
}

@Composable
fun CommonUiListItemLarge(
    modifier: Modifier = Modifier.fillMaxWidth(),

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
    border: BorderStroke? = null,
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
        border = border,
        attributes = CommonUiListItemAttributes.Large,
        onClick = onClick
    )
}

//
//@Composable
//fun CommonUiSecondaryListItem(
//    modifier: Modifier = Modifier,
//    text: String,
//    enabled: Boolean = true,
//    @DrawableRes iconResId: Int? = null,
//    imageVector: ImageVector? = null,
//    iconTint: Color = Color.Unspecified,
//    iconContentDescription: String = "",
//    textLetterSpacing: TextUnit = 0.sp,
//    maxLines: Int = 1,
//    overflow: TextOverflow = TextOverflow.Ellipsis,
//    attributes: CommonUiListItemAttributes = CommonUiListItemAttributes.Medium,
//    onClick: () -> Unit = {},
//) {
//    val borderColor: Color = if (enabled) colorBlack else colorGray_11
//
//    val colors = ButtonDefaults.buttonColors(
//        containerColor = colorWhite,
//        contentColor = colorBlack,
//        disabledContainerColor = colorWhite,
//        disabledContentColor = colorGray_11,
//    )
//
//    CommonUiListItem(
//        modifier = modifier,
//        text = text,
//        enabled = enabled,
//        leftIconResId = iconResId,
//        leftImageVector = imageVector,
//        leftIconTint = iconTint,
//        leftIconContentDescription = iconContentDescription,
//        textLetterSpacing = textLetterSpacing,
//        maxLines = maxLines,
//        overflow = overflow,
//        colors = colors,
//        border = BorderStroke(width = attributes.borderStrokeWidth, color = borderColor),
//        attributes = attributes,
//        onClick = onClick,
//    )
//}
//
//@Composable
//fun CommonUiContainerListItem(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    contentColor: Color = Color.White,
//    shape: Shape = RectangleShape,
//    content: @Composable () -> Unit,
//) = Box(
//    modifier = modifier
//        .clip(shape)
//        .clickable(
//            onClick = onClick,
//            enabled = enabled,
//            role = Role.Button,
//        ),
//    contentAlignment = Alignment.Center,
//) {
//    CompositionLocalProvider(
//        LocalContentColor provides contentColor,
//        content = content,
//    )
//}

@Composable
@Preview
private fun CommonUiListItemsPreviews() {
    Column(
        modifier = Modifier
            .background(Color.Cyan),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CommonUiListItemSmall(
            title = "Title".uppercase(),
        )

        CommonUiListItemSmall(
            title = "Title".uppercase(),
            content = "Content".uppercase()
        )

        CommonUiListItemSmall(
            title = "Title".uppercase(),
            content = "Content".uppercase(),
            leftIconResId = R.drawable.ic_info_circle,
            rightIconResId = R.drawable.ic_info_circle,
        )


        CommonUiListItemMedium(
            title = "Title".uppercase(),
        )

        CommonUiListItemMedium(
            title = "Title".uppercase(),
            content = "Content".uppercase(),
        )

        CommonUiListItemMedium(
            title = "Title".uppercase(),
            content = "Content".uppercase(),
            leftIconResId = R.drawable.ic_info_circle,
            rightIconResId = R.drawable.ic_info_circle,
        )



        CommonUiListItemLarge(
            title = "Text".uppercase(),
        )

        CommonUiListItemLarge(
            title = "Text".uppercase(),
            content = "Content".uppercase(),
        )

        CommonUiListItemLarge(
            title = "Title".uppercase(),
            content = "Content".uppercase(),
            leftIconResId = R.drawable.ic_info_circle,
            rightIconResId = R.drawable.ic_info_circle,
        )

        CommonUiListItem(
            title = "Title".uppercase(),
            attributes = CommonUiListItemAttributes.DynamicListItem(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                cornerRadius = 10.dp,
                titleStyle = CommonUiTypography900.bodyMedium,
                iconSize = 19.dp,
                spaceBetweenIconAndText = 6.8.dp,
                borderStrokeWidth = 4.dp,
            ),
            leftIconResId = R.drawable.ic_info_circle,
            rightIconResId = R.drawable.ic_info_circle,
        )

        CommonUiListItem(
            title = "Title".uppercase(),
            content = "Content".uppercase(),
            attributes = CommonUiListItemAttributes.DynamicListItem(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                cornerRadius = 10.dp,
                titleStyle = CommonUiTypography900.bodyMedium,
                iconSize = 19.dp,
                spaceBetweenIconAndText = 6.8.dp,
                borderStrokeWidth = 4.dp,
            )
        )

        CommonUiListItem(
            title = "Title".uppercase(),
            content = "Content".uppercase(),
            attributes = CommonUiListItemAttributes.DynamicListItem(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                cornerRadius = 10.dp,
                titleStyle = CommonUiTypography900.bodyMedium,
                iconSize = 19.dp,
                spaceBetweenIconAndText = 6.8.dp,
                borderStrokeWidth = 4.dp,
            ),
            leftIconResId = R.drawable.ic_info_circle,
            rightIconResId = R.drawable.ic_info_circle,
        )
    }
}
