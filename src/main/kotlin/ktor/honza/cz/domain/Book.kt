package ktor.honza.cz.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import java.time.LocalDate
import java.util.*

@Serializable
data class Book(
    @BsonId
    @Contextual
    val id: UUID = UUID.randomUUID(),
    val title: String,
    @Contextual
    val authorId: UUID,
    val authorName: String,
    @Contextual
    val releasedAt: LocalDate,
)
