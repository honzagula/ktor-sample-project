package ktor.honza.cz.model.command

import java.time.LocalDate
import java.util.UUID

data class BookAddCommand(
    val title: String,
    val authorId: UUID,
    val releasedAt: LocalDate
)
