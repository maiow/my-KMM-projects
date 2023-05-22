package com.mivanovskaya.ktorkmm

import com.russhwolf.settings.Settings
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = getPlatform()

    @Throws(Exception::class)
    suspend fun greet(): String {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        val settings = Settings()
        settings.putString("missionName", lastSuccessLaunch.missionName)
        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} and mission name was ${
                    settings.getString("missionName", "Unknown")} 🚀"
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
}
