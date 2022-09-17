package ktor.honza.cz

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import ktor.honza.cz.rest.installRouting
import ktor.honza.cz.routing.registerAuthorRoutes
import ktor.honza.cz.routing.registerBookRoutes
import ktor.honza.cz.setup.registerServices
import org.kodein.di.ktor.di

fun main() {
  embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
    di {
      registerServices()
    }

    installRouting()
    registerBookRoutes()
    registerAuthorRoutes()
  }.start(wait = true)
}
