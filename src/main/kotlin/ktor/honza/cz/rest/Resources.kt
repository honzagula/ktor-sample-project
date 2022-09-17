package ktor.honza.cz.rest

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
@Resource("/api/v1/books")
class BookResource {
  @Serializable
  @Resource("{id}")
  class ById(
      val parent: BookResource = BookResource(),
      @Serializable(with = UUIDSerializer::class)
      val id: UUID
  )
}
