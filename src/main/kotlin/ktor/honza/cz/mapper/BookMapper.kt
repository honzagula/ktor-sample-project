package ktor.honza.cz.mapper

import io.ktor.server.util.*
import ktor.honza.cz.domain.Book
import ktor.honza.cz.model.command.BookAddCommand
import ktor.honza.cz.model.request.BookAddRequest
import ktor.honza.cz.model.response.BookResponse
import java.time.Instant
import java.time.ZoneId
import java.util.*

fun BookAddRequest.toCommand() = BookAddCommand(
    title = title,
    authorId = authorId,
    releasedAt = releasedAt,
)

fun BookAddCommand.toDomain(authorName: String) = Book(
    title = title,
    authorId = authorId,
    authorName = authorName,
    releasedAt = releasedAt,
)

fun Book.toResponse() = BookResponse(
    id = id,
    title = title,
    authorId = authorId,
    releasedAt = releasedAt
)
