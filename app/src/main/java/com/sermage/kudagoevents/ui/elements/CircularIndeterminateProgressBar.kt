package com.sermage.kudagoevents.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.kudagoevents.ui.theme.KudaGoEventsTheme


@Composable
fun CircularIndeterminateProgressBar(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp,
        )
    }
}

@Preview
@Composable
fun CircularIndeterminateProgressBarPreview() {
    KudaGoEventsTheme {
        CircularIndeterminateProgressBar()
    }
}