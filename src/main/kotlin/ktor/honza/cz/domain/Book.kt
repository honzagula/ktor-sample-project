package ktor.honza.cz.domain

import java.util.*

data class Book(
    val id: UUID,
    val title: String,
    val authorId: UUID,
)

