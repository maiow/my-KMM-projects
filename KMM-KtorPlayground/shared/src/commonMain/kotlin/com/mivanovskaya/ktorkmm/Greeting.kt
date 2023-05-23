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
    private val settings: Settings = getSettings()

    @Throws(Exception::class)
    suspend fun greet(): String {
//        val rockets: List<RocketLaunch> =
//            httpClient.get("https://api.spacexdata.com/v4/launches").body()
//        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        KeyValueStorage(settings).platformName = platform.name
        KeyValueStorage(settings).language = "Kotlin"
        return "Guess what it is! > ${platform.nameWithVersion.reversed()}!" +
               // "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀" +
                "\nThis is ${KeyValueStorage(settings).platformName} application written on ${KeyValueStorage(settings).language}"
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
