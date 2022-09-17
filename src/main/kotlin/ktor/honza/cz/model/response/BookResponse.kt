package ktor.honza.cz.model.response

import kotlinx.serialization.Serializable
import ktor.honza.cz.rest.UUIDSerializer
import java.util.*

@Serializable
data class BookResponse(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val title: String,
    @Serializable(with = UUIDSerializer::class)
    val authorId: UUID,
)
