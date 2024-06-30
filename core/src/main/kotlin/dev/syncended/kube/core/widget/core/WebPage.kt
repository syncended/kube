package dev.syncended.kube.core.widget.core

import dev.syncended.kube.core.styling.webPageStyle
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
      head { style { text(webPageStyle()) } }
      body { render(this) }
    }.serialize(true)
  }
}

fun cleanWebPage(builder: WebPage.() -> Unit): String {
  val page = WebPage()
  page.builder()
  return page.render()
}
