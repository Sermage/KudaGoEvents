package com.sermage.kudagoevents.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.kudagoevents.R
import com.sermage.kudagoevents.ui.theme.KudaGoEventsTheme

@Composable
fun MainScreenError(
    modifier: Modifier = Modifier,
    onReloadClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(96.dp),
                imageVector = Icons.Rounded.Warning,
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = "Error loading items"
            )

            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
                text = stringResource(id = R.string.loading_error_text),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = MaterialTheme.shapes.small
                    ),
                onClick = onReloadClick
            ) {
                Text(
                    text = stringResource(id = R.string.refresh_button_title),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenErrorPreview() {
    KudaGoEventsTheme {
        MainScreenError(
            onReloadClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenErrorPreviewDark() {
    KudaGoEventsTheme(darkTheme = true) {
        MainScreenError(
            onReloadClick = {}
        )
    }
}