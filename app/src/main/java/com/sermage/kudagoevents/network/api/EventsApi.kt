package com.sermage.kudagoevents.network.api

import com.sermage.kudagoevents.network.response.EventsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val EVENTS_URL =
    "https://kudago.com/public-api/v1.4/events/?fields=id,title,description,images"

val client = HttpClient(Android) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
    install(Logging) {
        level = LogLevel.BODY
        logger = Logger.ANDROID
    }
}

suspend fun getEvents(): EventsResponse {
    return client.get(EVENTS_URL) {
        contentType(ContentType.Application.Json)
    }.body()
}