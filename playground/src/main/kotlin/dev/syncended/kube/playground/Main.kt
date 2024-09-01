package dev.syncended.kube.playground

import dev.syncended.kube.components.align
import dev.syncended.kube.components.text
import dev.syncended.kube.core.Alignment
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.render
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

fun Routing.getMain() = get("/") {
  call.respondText(mainPage(), ContentType.Text.Html)
}

fun mainPage(): String = render {
  column {
    modifier.align(Alignment.Horizontal.Center)

    text("value")

    row {
      text("Test")
      text("row")
    }

    text("value after row")
  }
}