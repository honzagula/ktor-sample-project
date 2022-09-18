package ktor.honza.cz.routing

import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.honza.cz.mapper.toCommand
import ktor.honza.cz.mapper.toResponse
import ktor.honza.cz.model.request.BookAddRequest
import ktor.honza.cz.model.response.BookResponse
import ktor.honza.cz.rest.BookResource
import ktor.honza.cz.rest.withRequest
import ktor.honza.cz.service.BookService
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import java.time.LocalDate
import java.util.UUID

fun Application.registerBookRoutes() {

  val bookService by closestDI().instance<BookService>()

  routing {
      get<BookResource.ById> { request ->
        call.respond(BookResponse(id = request.id, title = "Kniha", authorId = UUID.randomUUID(), releasedAt = LocalDate.MIN))
      }

    post<BookResource> {
      withRequest<BookAddRequest> { request ->
        request.toCommand()
            .run(bookService::addBook)
            .toResponse()
            .let { call.respond(it) }
      }
    }
  }


}
