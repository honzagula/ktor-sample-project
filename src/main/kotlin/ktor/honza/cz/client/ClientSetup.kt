package ktor.honza.cz.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlinx.serialization.json.Json

fun getClient() = HttpClient(CIO)

val json = Json {
  ignoreUnknownKeys = true
}
