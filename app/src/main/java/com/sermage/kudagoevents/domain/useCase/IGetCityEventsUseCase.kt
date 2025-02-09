package com.sermage.kudagoevents.domain.useCase

import com.sermage.kudagoevents.domain.model.CityEvents

interface IGetCityEventsUseCase {

    operator suspend fun invoke(): CityEvents
}