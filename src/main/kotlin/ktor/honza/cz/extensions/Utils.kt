package ktor.honza.cz.extensions

fun getEnv(variableName: String): String? = System.getenv(variableName)

inline fun <T : Any?> T.whenNull(block: () -> Unit): T {
  if (this == null) block()
  return this
}
