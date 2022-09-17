package ktor.honza.cz.service

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import ktor.honza.cz.client.AuthorClient
import ktor.honza.cz.client.AuthorClientResponse
import ktor.honza.cz.client.getClient
import ktor.honza.cz.domain.Author
import ktor.honza.cz.mapper.mapToDomain
import java.util.UUID

class AuthorService(
    private val authorClient: AuthorClient
) {

  suspend fun getAuthorByID(id: UUID): Author {
    return authorClient.getAuthorById(id).mapToDomain()
  }

  suspend fun getAuthors(): List<Author> {
    return authorClient.getAuthors().map {
      authorClient.getAuthorById(it.id).mapToDomain()
    }
  }

}
