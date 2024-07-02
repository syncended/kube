package dev.syncended.kube.playground

import dev.syncended.kube.core.styling.Gravity
import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.background
import dev.syncended.kube.core.styling.gravity
import dev.syncended.kube.core.styling.margin
import dev.syncended.kube.core.styling.maxWidth
import dev.syncended.kube.core.styling.px
import dev.syncended.kube.core.widget.core.cleanWebPage
import dev.syncended.kube.core.widget.element.text
import dev.syncended.kube.core.widget.layout.column
import dev.syncended.kube.core.widget.layout.row
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.clearPageRouting() = get("clear-web") {
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
    column(Modifier().maxWidth(600.px).background("#ff0000")) {
      text("abcd")
      text("fex")
    }

    row {
      text("aboba", Modifier().gravity(Gravity.CENTER))
      text("aboba", Modifier().gravity(Gravity.START))
      text("aboba", Modifier().gravity(Gravity.END))
    }

    row {
      column(modifier = Modifier().margin(right = 100.px)) {
        text("Hello v1")
        text("world v1")
      }
      column {
        text("Hello v2")
        text("world v2")
      }
    }
  }

  call.respondText(page, ContentType.Text.Html)
}