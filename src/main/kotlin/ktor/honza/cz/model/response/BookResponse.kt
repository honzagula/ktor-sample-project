package ktor.honza.cz.model.response

import kotlinx.serialization.Serializable
import ktor.honza.cz.rest.LocalDateSerializer
import ktor.honza.cz.rest.UUIDSerializer
import java.time.LocalDate
import java.util.*

@Serializable
data class BookResponse(
    @Serializable(UUIDSerializer::class)
    val id: UUID,
    val title: String,
    @Serializable(UUIDSerializer::class)
    val authorId: UUID,
    @Serializable(LocalDateSerializer::class)
    val releasedAt: LocalDate,
)
