package ktor.honza.cz.rest

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

fun Application.installRouting() {
  install(Resources)
  install(ContentNegotiation) {
    json()
  }
}

object UUIDSerializer : KSerializer<UUID> {
  override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

  override fun deserialize(decoder: Decoder): UUID {
    return UUID.fromString(decoder.decodeString())
  }

  override fun serialize(encoder: Encoder, value: UUID) {
    encoder.encodeString(value.toString())
  }
}
