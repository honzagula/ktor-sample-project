package ktor.honza.cz.domain

import java.util.UUID

data class Author(
    val id: UUID,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birth: String,
    val country: String,
    val description: String,
)
