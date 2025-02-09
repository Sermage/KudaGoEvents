package com.sermage.kudagoevents.domain.model

data class CityEvents(
    val count: Int,
    val next: String,
    val previous: String,
    val events: List<CityEvent>
)
