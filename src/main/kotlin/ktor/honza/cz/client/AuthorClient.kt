package ktor.honza.cz.client

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import ktor.honza.cz.rest.UUIDSerializer
import ktor.honza.cz.setup.properties.ClientProperties
import java.util.UUID

class AuthorClient(
    private val clientProperties: ClientProperties
) {
  suspend fun getAuthors() = get<List<AuthorClientResponse>>(url = "/authors")

  suspend fun getAuthorById(id: UUID) = get<AuthorDetailClientResponse>(url = "/authors/$id")

  private suspend inline fun <reified T> get(url: String): T {
    val client = getClient()
    val response = client.get(clientProperties.getWithBase(url))
    if (response.status.isSuccess()) {
      client.close()
      return extracted(response)
    }
    client.close()
    throw RuntimeException("Unable to get authors from remote API: ${response.status}")
  }

  private suspend inline fun <reified T> extracted(response: HttpResponse): T {
    response.bodyAsText().let {
      return json.decodeFromString(it) as T
    }
  }
}

@Serializable
data class AuthorClientResponse(
    @Serializable(UUIDSerializer::class)
    val id: UUID,
    val name: String,
)

@Serializable
data class AuthorDetailClientResponse(
    @Serializable(UUIDSerializer::class)
    val id: UUID,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birth: String,
    val country: String,
    val description: String,
)
