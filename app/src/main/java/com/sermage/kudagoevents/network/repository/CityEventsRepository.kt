package com.sermage.kudagoevents.network.repository

import com.sermage.kudagoevents.domain.model.CityEvents
import com.sermage.kudagoevents.network.api.getEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CityEventsRepository : ICityEventsRepository {

    override suspend fun getCityEvents(): CityEvents {
        return withContext(Dispatchers.IO) {
            getEvents().transform()
        }
    }
}