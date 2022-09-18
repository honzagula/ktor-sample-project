package ktor.honza.cz.service

import ktor.honza.cz.client.AuthorClient
import ktor.honza.cz.domain.Author
import ktor.honza.cz.mapper.toDomain
import java.util.UUID

class AuthorService(
    private val authorClient: AuthorClient
) {

  suspend fun getAuthorByID(id: UUID): Author {
    return authorClient.getAuthorById(id).toDomain()
  }

  suspend fun getAuthors(): List<Author> {
    return authorClient.getAuthors().map {
      authorClient.getAuthorById(it.id).toDomain()
    }
  }

}
