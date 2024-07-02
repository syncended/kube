package dev.syncended.kube.playground

import dev.syncended.kube.core.widget.core.kubeWebPage
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.webPageRouting() = get("web") {
  val page = kubeWebPage {

  }
  call.respondText(page, ContentType.Text.Html)
}