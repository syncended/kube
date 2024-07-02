package dev.syncended.kube.core.widget.element

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.Widget

class TextWidget(private val text: String, modifier: Modifier) : Widget(modifier) {
  override fun render() {
    p(classes = Design.Class.TEXT) {
      +text
    }
  }
}

fun Layout.text(text: String, modifier: Modifier = Modifier()) {
  val widget = TextWidget(text, modifier)
  add(widget)
}