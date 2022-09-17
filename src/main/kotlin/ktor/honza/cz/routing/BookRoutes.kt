package ktor.honza.cz.routing

import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.honza.cz.model.request.BookCreateRequest
import ktor.honza.cz.model.response.BookResponse
import ktor.honza.cz.rest.BookResource
import ktor.honza.cz.rest.withRequest
import java.util.UUID

fun Application.registerBookRoutes() {

  routing {
      get<BookResource.ById> { request ->
        call.respond(BookResponse(id = request.id, title = "Kniha", authorId = UUID.randomUUID()))
      }

      post<BookResource> {
        withRequest<BookCreateRequest> { request ->
          call.respond(BookResponse(id = UUID.randomUUID(), title = request.title, authorId = request.authorId))
        }
      }
  }


}
