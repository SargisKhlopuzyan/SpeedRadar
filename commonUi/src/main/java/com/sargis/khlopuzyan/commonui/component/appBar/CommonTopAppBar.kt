package com.sargis.khlopuzyan.commonui.component.appBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.commonui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar(
    title: String,
    icon: ImageVector? = Icons.AutoMirrored.Filled.ArrowBack,
    onClick: (() -> Unit)? = null,
) {
    CommonUiTheme {
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
                            stringResource(R.string.ic_arrow_back_desc),
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary,
                navigationIconContentColor = MaterialTheme.colorScheme.secondary,
                actionIconContentColor = MaterialTheme.colorScheme.secondary,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CommonTopAppBarPreview() {
    CommonUiTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CommonTopAppBar(title = "Test")

            CommonTopAppBar(title = "Test") {
            }

            CommonTopAppBar(
                title = "Test",
                icon = ImageVector.vectorResource(R.drawable.arrow_left)
            ) {
            }
        }
    }
}