package ktor.honza.cz.service

import ktor.honza.cz.domain.Author
import java.util.UUID

class AuthorService {

  fun getAuthorByID(id: UUID) = Author(id = id, firstName = "Pepa", lastName = "Zdepa")
}
