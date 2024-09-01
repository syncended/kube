package dev.syncended.kube.components

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.component.Modifier

class Text(
  modifier: TextModifier
) : Widget<TextModifier>(modifier) {

  override fun render() = p {
    +modifier.text.orEmpty()
  }
}

class TextModifier : Modifier() {
  var text: String? = null
}

fun TextModifier.text(text: String): TextModifier {
  this.text = text
  return this
}
