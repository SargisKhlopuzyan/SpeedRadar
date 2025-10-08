package com.sargis.khlopuzyan.commonui.component.appBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.sargis.khlopuzyan.commonui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar(
    title: String,
    icon: ImageVector? = Icons.AutoMirrored.Filled.ArrowBack,
    onClick: (() -> Unit)? = null,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (icon != null && onClick != null) {
                IconButton(
                    modifier = Modifier.wrapContentSize(),
                    onClick = onClick
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        "ArrowBack",
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(177, 185, 186, 255)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CommonTopAppBarPreview() {
    Column {
        CommonTopAppBar(title = "Test")
    }
}

@Preview(showBackground = true)
@Composable
fun CommonTopAppBarWithDefaultBackArrowPreview() {
    Column {
        CommonTopAppBar(title = "Test") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommonTopAppBarPreviewWithBackArrow() {
    CommonTopAppBar(title = "Test", icon = ImageVector.vectorResource(R.drawable.arrow_left)) {

    }
}