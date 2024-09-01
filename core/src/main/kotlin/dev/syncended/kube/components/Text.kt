package dev.syncended.kube.components

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.toCssColor
import kotlinx.css.CssBuilder
import kotlinx.css.color

class Text(
  modifier: TextModifier
) : Widget<TextModifier>(modifier) {

  override fun render() = p {
    +modifier.text.orEmpty()
  }

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    modifier.color?.let { builder.color = it.toCssColor() }
  }
}

class TextModifier : Modifier() {
  var text: String? = null
  var color: Color? = null
}

fun TextModifier.text(text: String): TextModifier {
  this.text = text
  return this
}

fun TextModifier.textColor(color: Color): TextModifier {
  this.color = color
  return this
}
