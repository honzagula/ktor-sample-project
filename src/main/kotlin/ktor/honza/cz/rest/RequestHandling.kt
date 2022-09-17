package ktor.honza.cz.rest

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.util.pipeline.*

suspend inline fun <reified T : Any> PipelineContext<*, ApplicationCall>.withRequest(body: (T) -> Unit) {
  return body(call.receive())
}
