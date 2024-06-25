package dev.syncended.kube.core.widget.core

import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.display
import kotlinx.css.fontFamily
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.html.FlowContent
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.style

class WebPage : Layout() {
  override fun render(parent: FlowContent) {
    widgets.forEach { it.render(parent) }
  }

  fun render(): String {
    return createHTMLDocument().html {
      head {
        style {
          text(pageStyle())
        }
      }
      body { render(this) }
    }.serialize(true)
  }
}

fun webPage(builder: WebPage.() -> Unit): String {
  val page = WebPage()
  page.builder()
  return page.render()
}

private fun pageStyle(): String {
  return CssBuilder().apply {
    all {
      padding = Padding(LinearDimension("0px"))
      margin = Margin(LinearDimension("0px"))

    }
    inline { display = Display.flex }
  }.toString()
}
