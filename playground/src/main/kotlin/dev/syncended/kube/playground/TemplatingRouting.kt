package dev.syncended.kube.playground

import dev.syncended.kube.core.widget.core.cleanWebPage
import dev.syncended.kube.core.widget.element.text
import dev.syncended.kube.core.widget.layout.centerHorizontal
import dev.syncended.kube.core.widget.layout.column
import dev.syncended.kube.core.widget.layout.row
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.helloWorld() = get("hello-world") {
  val page = cleanWebPage {
    text("Hello world!")
    column {
      text("Hello")
      text("World")
      row {
        text("Hello")
        text("World")
      }
    }
    row {
      centerHorizontal { text("test") }
      centerHorizontal { text("test") }
    }
  }

  call.respondText(page, ContentType.Text.Html)
}