package com.sermage.kudagoevents.network.response

import com.sermage.kudagoevents.domain.model.CityEvent
import com.sermage.kudagoevents.domain.model.EventImage
import com.sermage.kudagoevents.util.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class EventObj(
    val id: Int?,
    val title: String?,
    val description: String?,
    val images: List<ImageObj>?
) : Transformable<CityEvent> {
    override fun transform(): CityEvent {
        return CityEvent(
            id = id ?: 0,
            title = title.orEmpty(),
            description = description.orEmpty(),
            images = images?.map { it.transform() } ?: emptyList()
        )
    }
}

@Serializable
data class ImageObj(val image: String?) : Transformable<EventImage> {

    override fun transform(): EventImage {
        return EventImage(image.orEmpty())
    }
}
