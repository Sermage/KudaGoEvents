package com.sermage.kudagoevents.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sermage.kudagoevents.ui.elements.CircularIndeterminateProgressBar
import com.sermage.kudagoevents.ui.elements.CityEventItemCard

@Composable
fun MainScreen() {
    val vm = hiltViewModel<MainScreenViewModel>()
    val state = vm.screenState.collectAsState().value

    Box(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        when (state) {
            is MainScreenState.Loading -> {
                CircularIndeterminateProgressBar(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .padding(top = 56.dp)
                )
            }

            is MainScreenState.Content -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    state.events.forEach { cityEvent ->
                        item(
                            key = cityEvent.id
                        ) {
                            CityEventItemCard(
                                modifier = Modifier.padding(12.dp),
                                cityEvent = cityEvent
                            )
                        }
                    }
                }
            }

            is MainScreenState.EmptyResult -> {}
            is MainScreenState.Error -> {
                MainScreenError(onReloadClick = {})
            }
        }
    }
}