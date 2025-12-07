package dev.syncended.kube.ktor.core

import dev.syncended.kube.components.layout.FlatLayout
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.dsl.render
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respondText
import io.ktor.server.routing.RoutingCall

suspend inline fun RoutingCall.respondRender(
  status: HttpStatusCode = HttpStatusCode.OK,
  mode: RenderMode = RenderMode.PAGE,
  body: FlatLayout.() -> Unit
) {
  val content = render(
    mode = mode,
    body = body
  )
  respondText(text = content, contentType = ContentType.Text.Html, status = status)
}

suspend inline fun RoutingCall.respondRenderView(
  status: HttpStatusCode = HttpStatusCode.OK,
  body: FlatLayout.() -> Unit
) {
  val content = render(
    mode = RenderMode.VIEW_ONLY,
    body = body
  )
  respondText(text = content, contentType = ContentType.Text.Html, status = status)
}