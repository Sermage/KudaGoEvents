package com.sermage.kudagoevents.network.response

import com.sermage.kudagoevents.domain.model.CityEvents
import com.sermage.kudagoevents.util.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class EventsResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<EventObj>? = null
) : Transformable<CityEvents> {

    override fun transform(): CityEvents {
        return CityEvents(
            count = count ?: 0,
            next = next.orEmpty(),
            previous = previous.orEmpty(),
            events = results?.map { it.transform() } ?: emptyList()
        )
    }
}