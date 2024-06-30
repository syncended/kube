package dev.syncended.kube.core.widget.element

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.buildStyle
import dev.syncended.kube.core.styling.modifier
import dev.syncended.kube.core.widget.core.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.Widget
import kotlinx.html.FlowContent
import kotlinx.html.p
import kotlinx.html.style

class TextWidget(private val text: String, modifier: Modifier) : Widget(modifier) {
  override fun render(parent: FlowContent) {
    parent.p(classes = Design.Class.TEXT) {
      style = modifier.buildStyle()
      +text
    }
  }
}

fun Layout.text(text: String, modifier: Modifier = modifier()) {
  val widget = TextWidget(text, modifier)
  add(widget)
}