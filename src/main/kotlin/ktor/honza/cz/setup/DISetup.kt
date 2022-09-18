package ktor.honza.cz.setup

import kotlinx.nosql.CreateDrop
import kotlinx.nosql.mongodb.MongoDB
import ktor.honza.cz.client.AuthorClient
import ktor.honza.cz.domain.Books
import ktor.honza.cz.enums.EnvVariables
import ktor.honza.cz.extensions.getEnv
import ktor.honza.cz.extensions.whenNull
import ktor.honza.cz.service.AuthorService
import ktor.honza.cz.service.BookService
import ktor.honza.cz.setup.properties.ClientProperties
import mu.KotlinLogging.logger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

private val log = logger {}


fun DI.MainBuilder.registerProperties() {
  bind<ClientProperties>() with singleton {
    ClientProperties(
        baseUrl = getEnvOrLogDefault(EnvVariables.CLIENT_BASE_URL, "https://d35k5.mocklab.io")
    )
  }
}

fun DI.MainBuilder.registerDatabase() {
  bind<MongoDB>() with singleton { MongoDB(database = "localhost", schemas = arrayOf(Books), action = CreateDrop()) }
}

fun DI.MainBuilder.registerClients() {
  bind<AuthorClient>() with singleton { AuthorClient(instance()) }
}

fun DI.MainBuilder.registerServices() {
  bind<AuthorService>() with singleton { AuthorService(instance()) }
  bind<BookService>() with singleton { BookService(db = instance(), authorService = instance()) }
}

private fun getEnvOrLogDefault(env: EnvVariables, defaultValue: String) =
    getEnv(env.name)
        .whenNull { log.warn { "Env variable $env not set! Using default value - $defaultValue" } }
        ?: defaultValue
private fun requireEnv(env: EnvVariables) =
    requireNotNull(getEnv(env.name)) { "${env.name} env variable was not provided. Exiting." }
