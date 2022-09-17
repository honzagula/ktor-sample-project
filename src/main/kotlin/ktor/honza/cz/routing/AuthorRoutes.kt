package ktor.honza.cz.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.honza.cz.service.AuthorService
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import java.util.UUID

val authorRoute = apiV1Route("/authors")

fun Application.registerAuthorRoutes() {
  val authorService by closestDI().instance<AuthorService>()

  routing {
    route(authorRoute) {
      get {
        call.respondText("Author route rulez!")
      }

      get("/{id}") {
        call.parameters["id"].let(UUID::fromString).run(authorService::getAuthorByID)
            .lastName
            .let { call.respondText(it) }
      }
    }
  }
}
