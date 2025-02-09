package com.sermage.kudagoevents.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sermage.kudagoevents.domain.model.CityEvent
import com.sermage.kudagoevents.domain.useCase.IGetCityEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCityEventsUseCase: IGetCityEventsUseCase
) : ViewModel() {

    private val mutableScreenState = MutableStateFlow<MainScreenState>(MainScreenState.Loading)

    val screenState = mutableScreenState.asStateFlow()

    init {
        getCityEvents()
    }

    private fun getCityEvents() {
        flow {
            emit(getCityEventsUseCase())
        }
            .onStart { mutableScreenState.emit(MainScreenState.Loading) }
            .map { it.events }
            .onEach { emitCityEvents(it) }
            .catch { handleError(it) }
            .launchIn(viewModelScope)
    }

    private suspend fun emitCityEvents(cityEvents: List<CityEvent>) {
        mutableScreenState.emit(MainScreenState.Content(cityEvents)
            .takeIf { cityEvents.isNotEmpty() } ?: MainScreenState.EmptyResult)
    }

    private suspend fun handleError(error: Throwable) = mutableScreenState.emit(
        MainScreenState.Error(
            error.message ?: "Something went wrong"
        )
    )
}