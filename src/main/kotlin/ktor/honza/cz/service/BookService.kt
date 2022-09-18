package ktor.honza.cz.service

import ktor.honza.cz.dao.BookDao
import ktor.honza.cz.mapper.fullName
import ktor.honza.cz.mapper.toDomain
import ktor.honza.cz.model.command.BookAddCommand

class BookService(
    private val bookDao: BookDao,
    private val authorService: AuthorService,
) {

  suspend fun addBook(command: BookAddCommand) = authorService.getAuthorByID(command.authorId)
      .fullName()
      .let { command.toDomain(it) }
      .run { bookDao.addBook(this) }

  suspend fun findAllBooks() = bookDao.findAllBooks()

}
