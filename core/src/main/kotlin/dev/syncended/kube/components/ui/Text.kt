package dev.syncended.kube.components.ui

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.Widget
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

class Text(
  modifier: Modifier = Modifier.Modifier,
  private val color: Color?,
  private val textSize: Size?,
  private val fontSize: FontSize?,
  private val fontStyle: FontStyle?,
  private val text: String? = null,
) : Widget(modifier) {

  override fun render() = p {
    +text.orEmpty()
  }

  override fun applyStyling(builder: CssBuilder) {
    super.applyStyling(builder)
    color?.let { builder.color = it.toCssColor() }
    textSize?.let { builder.fontSize = it.toDimension() }
    fontSize?.let { builder.fontWeight = it.mapping }
    fontStyle?.let { builder.fontStyle = it.mapping }
  }
}