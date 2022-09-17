package ktor.honza.cz.domain

import java.util.UUID

data class Author(
    val id: UUID,
    val firstName: String,
    val lastName: String,
)
