package com.sermage.kudagoevents.domain.model

data class CityEvent(
    val id: Int,
    val title: String,
    val description: String,
    val images: List<EventImage>
)

data class EventImage(val image: String)
