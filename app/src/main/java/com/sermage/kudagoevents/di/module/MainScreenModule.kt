package com.sermage.kudagoevents.di.module

import com.sermage.kudagoevents.domain.useCase.GetCityEventsUseCase
import com.sermage.kudagoevents.domain.useCase.IGetCityEventsUseCase
import com.sermage.kudagoevents.network.repository.CityEventsRepository
import com.sermage.kudagoevents.network.repository.ICityEventsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainScreenModule {

    @Provides
    fun provideCityEventsRepository(): ICityEventsRepository = CityEventsRepository()


    @Provides
    fun provideGetCityEventsUseCase(
        cityEventsRepository: ICityEventsRepository
    ): IGetCityEventsUseCase {
        return GetCityEventsUseCase(cityEventsRepository)
    }
}