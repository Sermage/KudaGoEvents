package com.sermage.kudagoevents.ui.screens.main

import com.sermage.kudagoevents.domain.model.CityEvent

sealed class MainScreenState {
    object Loading : MainScreenState()

    object EmptyResult : MainScreenState()

    data class Content(val events: List<CityEvent>) : MainScreenState()

    data class Error(val message: String) : MainScreenState()
}