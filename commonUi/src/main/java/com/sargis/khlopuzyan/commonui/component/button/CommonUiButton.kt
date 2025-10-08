package com.sargis.khlopuzyan.commonui.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sargis.khlopuzyan.commonui.CommonUiTheme
//import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.commonui.CommonUiTypography900
import com.sargis.khlopuzyan.commonui.R
import com.sargis.khlopuzyan.commonui.colorBlack
import com.sargis.khlopuzyan.commonui.colorGray_11
import com.sargis.khlopuzyan.commonui.colorGray_13
import com.sargis.khlopuzyan.commonui.colorGray_9
import com.sargis.khlopuzyan.commonui.colorWhite
import com.sargis.khlopuzyan.commonui.util.NoRippleInteractionSource

@Composable
private fun CommonUiButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    @DrawableRes iconResId: Int? = null,
    imageVector: ImageVector? = null,
    iconTint: Color = Color.Unspecified,
    iconContentDescription: String = "",
    textLetterSpacing: TextUnit = 0.sp,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
//    attributes: CommonUiButtonAttributes = CommonUiTheme.buttonStyle.medium,
    attributes: CommonUiButtonAttributes = CommonUiButtonAttributes.Medium,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier.height(attributes.height),
        contentPadding = attributes.contentPadding,
        shape = RoundedCornerShape(attributes.cornerRadius),
        border = border,
        colors = colors,
        enabled = enabled,
        interactionSource = NoRippleInteractionSource(),
        onClick = onClick,
    ) {
        when {
            iconResId != null -> {
                Icon(
                    modifier = Modifier.size(attributes.iconSize),
                    painter = painterResource(id = iconResId),
                    tint = if (iconTint != Color.Unspecified) iconTint else LocalContentColor.current,
                    contentDescription = iconContentDescription,
                )
            }

            imageVector != null -> {
                Icon(
                    modifier = Modifier.size(attributes.iconSize),
                    imageVector = imageVector,
                    tint = if (iconTint != Color.Unspecified) iconTint else LocalContentColor.current,
                    contentDescription = iconContentDescription,
                )
            }
        }
        if (iconResId != null || imageVector != null) {
            Spacer(modifier = Modifier.width(attributes.spaceBetweenIconAndText))
        }
        Text(
            text = text,
            style = attributes.textStyle,
            textAlign = TextAlign.Center,
            maxLines = maxLines,
            overflow = overflow,
            letterSpacing = textLetterSpacing,
        )
    }
}

@Composable
fun CommonUiPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    @DrawableRes iconResId: Int? = null,
    imageVector: ImageVector? = null,
    iconTint: Color = Color.Unspecified,
    iconContentDescription: String = "",
    textLetterSpacing: TextUnit = 0.sp,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
//    attributes: CommonUiButtonAttributes = CommonUiTheme.buttonStyle.medium,
    attributes: CommonUiButtonAttributes = CommonUiButtonAttributes.Medium,
    onClick: () -> Unit = {},
) {
    val colors = ButtonDefaults.buttonColors(
        containerColor = colorBlack,
        contentColor = colorWhite,
        disabledContainerColor = colorGray_13,
        disabledContentColor = colorGray_9,
    )
    CommonUiButton(
        modifier = modifier,
        text = text,
        enabled = enabled,
        iconResId = iconResId,
        imageVector = imageVector,
        iconTint = iconTint,
        iconContentDescription = iconContentDescription,
        textLetterSpacing = textLetterSpacing,
        maxLines = maxLines,
        overflow = overflow,
        colors = colors,
        attributes = attributes,
        onClick = onClick,
    )
}

@Composable
fun CommonUiSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    @DrawableRes iconResId: Int? = null,
    imageVector: ImageVector? = null,
    iconTint: Color = Color.Unspecified,
    iconContentDescription: String = "",
    textLetterSpacing: TextUnit = 0.sp,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
//    attributes: CommonUiButtonAttributes = CommonUiTheme.buttonStyle.medium,
    attributes: CommonUiButtonAttributes = CommonUiButtonAttributes.Medium,
    onClick: () -> Unit = {},
) {
    val borderColor: Color = if (enabled) colorBlack else colorGray_11

    val colors = ButtonDefaults.buttonColors(
        containerColor = colorWhite,
        contentColor = colorBlack,
        disabledContainerColor = colorWhite,
        disabledContentColor = colorGray_11,
    )

    CommonUiButton(
        modifier = modifier,
        text = text,
        enabled = enabled,
        iconResId = iconResId,
        imageVector = imageVector,
        iconTint = iconTint,
        iconContentDescription = iconContentDescription,
        textLetterSpacing = textLetterSpacing,
        maxLines = maxLines,
        overflow = overflow,
        colors = colors,
        border = BorderStroke(width = attributes.borderStrokeWidth, color = borderColor),
        attributes = attributes,
        onClick = onClick,
    )
}

@Composable
fun CommonUiContainerButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentColor: Color = Color.White,
    shape: Shape = RectangleShape,
    content: @Composable () -> Unit,
) = Box(
    modifier = modifier
        .clip(shape)
        .clickable(
            onClick = onClick,
            enabled = enabled,
            role = Role.Button,
        ),
    contentAlignment = Alignment.Center,
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        content = content,
    )
}

@Composable
@Preview
private fun CommonUiButtonsPreviews() {
    CommonUiTheme {
        Surface {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                // Primary button
                CommonUiPrimaryButton(
                    text = "Text".uppercase(),
//                    attributes = CommonUiTheme.buttonStyle.small,
                    attributes = CommonUiButtonAttributes.Small,
                )

                CommonUiPrimaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.medium,
                    attributes = CommonUiButtonAttributes.Medium,
                )

                Row {
                    CommonUiPrimaryButton(
                        modifier = Modifier.weight(1F),
                        text = "Text",
//                        attributes = CommonUiTheme.buttonStyle.medium,
                        attributes = CommonUiButtonAttributes.Medium,
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    CommonUiPrimaryButton(
                        modifier = Modifier.weight(1F),
                        text = "Text",
//                        attributes = CommonUiTheme.buttonStyle.medium,
                        attributes = CommonUiButtonAttributes.Medium,
                    )
                }

                CommonUiPrimaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.large,
                    attributes = CommonUiButtonAttributes.Large,
                )

                CommonUiPrimaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.medium,
                    attributes = CommonUiButtonAttributes.Medium,
                    iconResId = R.drawable.ic_info_circle,
                )

                CommonUiPrimaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.medium,
                    attributes = CommonUiButtonAttributes.Medium,
                    iconResId = R.drawable.ic_info_circle,
                    enabled = false,
                )

                // Secondary button

                CommonUiSecondaryButton(
                    text = "Text".uppercase(),
//                    attributes = CommonUiTheme.buttonStyle.small,
                    attributes = CommonUiButtonAttributes.Small,
                )

                CommonUiSecondaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.medium,
                    attributes = CommonUiButtonAttributes.Medium,
                )

                CommonUiSecondaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.large,
                    attributes = CommonUiButtonAttributes.Large,
                )

                CommonUiSecondaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.medium,
                    attributes = CommonUiButtonAttributes.Medium,
                    iconResId = R.drawable.ic_info_circle,
                )

                CommonUiSecondaryButton(
                    text = "Text",
//                    attributes = CommonUiTheme.buttonStyle.medium,
                    attributes = CommonUiButtonAttributes.Medium,
                    iconResId = R.drawable.ic_info_circle,
                    enabled = false,
                )

                CommonUiPrimaryButton(
                    text = "Text",
                    attributes = CommonUiButtonAttributes.DynamicButton(),
                    iconResId = R.drawable.ic_info_circle,
                )

                CommonUiSecondaryButton(
                    text = "Text",
                    attributes = CommonUiButtonAttributes.DynamicButton(),
                    iconResId = R.drawable.ic_info_circle,
                )

                CommonUiSecondaryButton(
                    text = "Text",
                    attributes = CommonUiButtonAttributes.DynamicButton(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        cornerRadius = 10.dp,
                        textStyle = CommonUiTypography900.bodyMedium,
                        iconSize = 19.dp,
                        spaceBetweenIconAndText = 6.8.dp,
                        borderStrokeWidth = 4.dp,
                    ),
                    iconResId = R.drawable.ic_info_circle,
                )
            }
        }
    }
}
