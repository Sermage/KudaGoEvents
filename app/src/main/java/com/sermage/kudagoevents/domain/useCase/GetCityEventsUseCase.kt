package com.sermage.kudagoevents.domain.useCase

import com.sermage.kudagoevents.domain.model.CityEvents
import com.sermage.kudagoevents.network.repository.ICityEventsRepository

class GetCityEventsUseCase(
    private val cityEventsRepository: ICityEventsRepository
) : IGetCityEventsUseCase {

    override suspend fun invoke(): CityEvents {
        return cityEventsRepository.getCityEvents()
    }
}