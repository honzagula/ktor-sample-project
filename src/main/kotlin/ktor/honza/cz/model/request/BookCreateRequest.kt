package ktor.honza.cz.model.request

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import ktor.honza.cz.rest.UUIDSerializer
import java.util.UUID

@Serializable
@Resource("/create")
data class BookCreateRequest(
    val title: String = "",
    @Serializable(with = UUIDSerializer::class)
    val authorId: UUID = UUID.randomUUID()
)
