package dev.syncended.kube.core.widget.core

import dev.syncended.kube.core.styling.Alignment
import dev.syncended.kube.core.styling.Design
import dev.syncended.kube.core.styling.Gravity
import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.alignment
import dev.syncended.kube.core.styling.background
import dev.syncended.kube.core.styling.gravity
import dev.syncended.kube.core.styling.height
import dev.syncended.kube.core.styling.maxWidth
import dev.syncended.kube.core.styling.percent
import dev.syncended.kube.core.styling.size
import dev.syncended.kube.core.styling.webPageStyle
import dev.syncended.kube.core.styling.width
import dev.syncended.kube.core.widget.element.text
import dev.syncended.kube.core.widget.layout.ColumnLayout
import dev.syncended.kube.core.widget.layout.column
import dev.syncended.kube.core.widget.layout.flatLayout
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.style

class WebPage : ColumnLayout(Modifier()) {

  fun build(): String {
    return createHTMLDocument().html {
      head { style { text(webPageStyle()) } }
      body {
        attach(this)
        render()
      }
    }.serialize(true)
  }
}

fun cleanWebPage(builder: WebPage.() -> Unit): String {
  val page = WebPage()
  page.builder()
  return page.build()
}

fun kubeWebPage(builder: Layout.() -> Unit): String {
  val page = WebPage()
  page.column(
    modifier = Modifier()
      .maxWidth(Design.Size.MaxWidth)
      .width(100.percent)
      .gravity(Gravity.CENTER)
  ) {
    toolbar()
    builder()
  }
  return page.build()
}

private fun Layout.toolbar() = column(
  modifier = Modifier()
    .size(
      width = 100.percent,
      height = Design.Size.ToolbarHeight
    )
    .alignment(Alignment.CENTER)
    .background(Design.Color.PRIMARY)
) {
  text("KUBE")
}
