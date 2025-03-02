package dev.syncended.kube.ktor.core

import dev.syncended.kube.core.KubeStyling
import dev.syncended.kube.core.model.FontResource
import dev.syncended.kube.core.model.extension
import dev.syncended.kube.core.model.getBytes
import dev.syncended.kube.core.model.name
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.route

private val mainCss = KubeStyling.buildStyle()

internal fun Routing.resourcesRouting(basePath: String) = route(basePath) {
  getMainCss()
  getFont()
}

private fun Route.getMainCss() = get("/css/main.css") {
  call.respondText(text = mainCss, contentType = ContentType.Text.CSS, HttpStatusCode.OK)
}

private fun Route.getFont() = get("/font/{path}") {
  val path = call.pathParameters["path"]
  val font = KubeStyling.getFonts().flatMap { it.resources }
    .find { it.name == path }

  val bytes = font?.getBytes()
  if (bytes == null) {
    call.respondText("", status = HttpStatusCode.NotFound)
  } else {
    call.respondBytes(bytes = bytes, contentType = font.contentType, HttpStatusCode.OK)
  }
}

internal val FontResource.contentType: ContentType
  get() = when (extension.lowercase()) {
    "woff2" -> ContentType.Font.Woff2
    else -> ContentType.Font.Ttf
  }