package ktor.honza.cz.dao

import kotlinx.coroutines.runBlocking
import ktor.honza.cz.domain.Book
import org.litote.kmongo.coroutine.CoroutineDatabase

class BookDao(
    mongo: CoroutineDatabase
) {
  private val collection = mongo.getCollection<Book>().also {
    runBlocking {
      it.ensureUniqueIndex(Book::id)
    }
  }

  suspend fun addBook(book: Book) = book.also { collection.insertOne(it) }

  suspend fun findAllBooks() = collection.find().toList()


}
