package dev.syncended.kube.playground

import dev.syncended.kube.components.align
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.paddingLeft
import dev.syncended.kube.core.component.paddingTop
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.px
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.styling.Colors
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

fun Routing.getMain() = get("/") {
  call.respondText(mainPage(), ContentType.Text.Html)
}

fun mainPage(): String = column {
  modifier.align(Alignment.Horizontal.Center)
    .paddingTop(10.px)

  text("value")

  row {
    text("Test") { modifier.backgorundColor(Colors.red) }
    text("row")
  }

  text("value after row")
}