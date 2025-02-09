package com.sermage.kudagoevents.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sermage.kudagoevents.ui.screens.main.MainScreen
import com.sermage.kudagoevents.ui.theme.KudaGoEventsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KudaGoEventsTheme {
                MainScreen()
            }
        }
    }
}