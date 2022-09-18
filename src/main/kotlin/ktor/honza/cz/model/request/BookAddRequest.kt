package ktor.honza.cz.model.request

import kotlinx.serialization.Serializable
import ktor.honza.cz.rest.LocalDateSerializer
import ktor.honza.cz.rest.UUIDSerializer
import java.time.LocalDate
import java.util.UUID

@Serializable
data class BookAddRequest(
    val title: String = "",
    @Serializable(with = UUIDSerializer::class)
    val authorId: UUID = UUID.randomUUID(),
    @Serializable(LocalDateSerializer::class)
    val releasedAt: LocalDate,
)
