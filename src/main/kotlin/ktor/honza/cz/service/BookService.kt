package ktor.honza.cz.service

import kotlinx.nosql.mongodb.MongoDB
import ktor.honza.cz.domain.Books
import ktor.honza.cz.mapper.toDomain
import ktor.honza.cz.model.command.BookAddCommand

class BookService(
    private val db: MongoDB,
    private val authorService: AuthorService,
) {

  fun addBook(command: BookAddCommand) = db.withSession {
    command.toDomain()
        .also { Books.insert(it) }
  }

}
