package dev.syncended.kube.core.widget.element

import dev.syncended.kube.core.widget.core.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.Widget
import kotlinx.html.FlowContent
import kotlinx.html.p

class TextWidget(private val text: String) : Widget() {
  override fun render(parent: FlowContent) {
    parent.p(classes = Design.Class.TEXT) { +text }
  }
}

fun Layout.text(text: String) {
  val widget = TextWidget(text)
  add(widget)
}