package ktor.honza.cz.model.response

import kotlinx.serialization.Serializable
import ktor.honza.cz.rest.UUIDSerializer
import java.util.UUID

@Serializable
data class AuthorResponse(
    @Serializable(UUIDSerializer::class)
    val id: UUID,
    val fullName: String,
    val dateOfBirth: String,
    val country: String,
)
