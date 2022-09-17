package ktor.honza.cz.setup.properties

data class ClientProperties(
    val baseUrl: String,
) {
  fun getWithBase(url: String) = "$baseUrl$url"
}
