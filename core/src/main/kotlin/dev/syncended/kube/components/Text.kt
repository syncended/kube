package dev.syncended.kube.components

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.component.DeprModifier
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

open class TextModifier : DeprModifier() {
  internal var text: String? = null
  internal var color: Color? = null
  internal var textSize: Size? = null
  internal var fontSize: FontSize? = null
  internal var fontStyle: FontStyle? = null
}

fun <T : TextModifier> T.text(text: String): T {
  this.text = text
  return this
}

fun <T : TextModifier> T.textColor(color: Color): T {
  this.color = color
  return this
}

fun <T : TextModifier> T.textSize(value: Size): T {
  textSize = value
  return this
}

fun <T : TextModifier> T.fontSize(fontSize: FontSize): T {
  this.fontSize = fontSize
  return this
}

fun <T : TextModifier> T.fontStyle(fontStyle: FontStyle): T {
  this.fontStyle = fontStyle
  return this
}
