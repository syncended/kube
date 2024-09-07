package dev.syncended.kube.components

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.core.model.FontStyle
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.core.model.toCssColor
import kotlinx.css.CssBuilder
import kotlinx.css.color
import kotlinx.css.fontSize
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight

abstract class AbstractText<M : TextModifier>(modifier: M) : Widget<M>(modifier) {

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    modifier.color?.let { builder.color = it.toCssColor() }
    modifier.textSize?.let { builder.fontSize = it.toDimension() }
    modifier.fontSize?.let { builder.fontWeight = it.mapping }
    modifier.fontStyle?.let { builder.fontStyle = it.mapping }
  }
}

class Text(modifier: TextModifier) : AbstractText<TextModifier>(modifier) {

  override fun render() = p {
    +modifier.text.orEmpty()
  }
}

open class TextModifier : Modifier() {
  internal var text: String? = null
  internal var color: Color? = null
  internal var textSize: Size? = null
  internal var fontSize: FontSize? = null
  internal var fontStyle: FontStyle? = null
}

fun TextModifier.text(text: String): TextModifier {
  this.text = text
  return this
}

fun TextModifier.textColor(color: Color): TextModifier {
  this.color = color
  return this
}

fun TextModifier.textSize(value: Size): TextModifier {
  textSize = value
  return this
}

fun TextModifier.fontSize(fontSize: FontSize): TextModifier {
  this.fontSize = fontSize
  return this
}

fun TextModifier.fontStyle(fontStyle: FontStyle): TextModifier {
  this.fontStyle = fontStyle
  return this
}
