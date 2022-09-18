package ktor.honza.cz.domain

import kotlinx.nosql.date
import kotlinx.nosql.dateTime
import kotlinx.nosql.mongodb.DocumentSchema
import kotlinx.nosql.string
import ktor.honza.cz.extensions.uuid
import java.time.LocalDate
import java.util.*

data class Book(
    val id: UUID,
    val title: String,
    val authorId: UUID,
    val releasedAt: Date,
)

object Books : DocumentSchema<Book>("books", Book::class) {
  val title = string("title")
  val authorId = uuid("authorId")
  val releasedAt = date("releasedAt")
  val createdAt = dateTime("createdAt")
}
