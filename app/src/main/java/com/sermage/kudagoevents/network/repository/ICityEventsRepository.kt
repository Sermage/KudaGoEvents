package com.sermage.kudagoevents.network.repository

import com.sermage.kudagoevents.domain.model.CityEvents

interface ICityEventsRepository {

    suspend fun getCityEvents(): CityEvents
}