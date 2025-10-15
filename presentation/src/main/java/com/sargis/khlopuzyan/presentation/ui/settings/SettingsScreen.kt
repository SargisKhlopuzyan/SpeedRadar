package com.sargis.khlopuzyan.presentation.ui.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sargis.khlopuzyan.commonui.CommonUiTheme
import com.sargis.khlopuzyan.commonui.component.appBar.CommonTopAppBar
import com.sargis.khlopuzyan.commonui.component.list.CommonUiListItemHeaderSmall
import com.sargis.khlopuzyan.commonui.component.list.CommonUiListItemMedium
import com.sargis.khlopuzyan.presentation.R

@Composable
fun SettingsScreen(
    uiState: SettingsUiState,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.settings)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            item {
                CommonUiListItemHeaderSmall(
                    header = stringResource(R.string.select_your_country),
                    showDivider = false
                )
            }

            item {
                CommonUiListItemMedium(
                    leftIconResId = com.sargis.khlopuzyan.commonui.R.drawable.flag_am,
                    title = stringResource(R.string.country),
                    content = stringResource(R.string.country),
                    showDivider = true
                )
            }

            item {
                CommonUiListItemMedium(
                    leftIconResId = com.sargis.khlopuzyan.commonui.R.drawable.seek_right,
                    title = stringResource(R.string.update_warnings_database),
                    showDivider = false
                )
            }

            item {
                CommonUiListItemHeaderSmall(
                    header = stringResource(R.string.warnings_speed_radar),
                    showDivider = false
                )
            }

            item {
                CommonUiListItemMedium(
                    leftIconResId = com.sargis.khlopuzyan.commonui.R.drawable.close,
                    title = stringResource(R.string.configure_alerts),
                    showDivider = true
                )
            }

            item {
                CommonUiListItemMedium(
                    leftIconResId = com.sargis.khlopuzyan.commonui.R.drawable.close,
                    title = stringResource(R.string.adjust_volume),
                    showDivider = true
                )
            }

            item {
                CommonUiListItemMedium(
                    leftIconResId = com.sargis.khlopuzyan.commonui.R.drawable.close,
                    title = stringResource(R.string.visual_warnings),
                    showDivider = false
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    CommonUiTheme {
        SettingsScreen(
            SettingsUiState()
        )
    }
}