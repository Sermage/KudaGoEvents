package com.sermage.kudagoevents.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.sermage.kudagoevents.domain.model.CityEvent
import com.sermage.kudagoevents.domain.model.EventImage
import com.sermage.kudagoevents.ui.theme.KudaGoEventsTheme

@Composable
fun CityEventItemCard(
    cityEvent: CityEvent,
    modifier: Modifier = Modifier,
    onCardClick: (Int) -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .shadow(elevation = 10.dp),
        onClick = { onCardClick(cityEvent.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(cityEvent.images.firstOrNull()?.image)
                    .build(),
                contentDescription = "Event photo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = cityEvent.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 12.dp, end = 12.dp)
            )

            Text(
                text = cityEvent.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CityEventItemCardPreview() {
    KudaGoEventsTheme {
        CityEventItemCard(
            cityEvent = CityEvent(
                id = 1,
                title = "Концерт Rammstein",
                description = "Впервые в нашем городе легенадарная немецкая рок-группа проведет концерт на стадионе",
                images = listOf(EventImage("https://i.pinimg.com/736x/4e/6d/48/4e6d48252039e8a826f2c280702bee78.jpg"))
            )
        )
    }
}