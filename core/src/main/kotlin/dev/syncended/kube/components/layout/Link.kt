package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.core.model.FontStyle
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.core.model.toCssColor
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Colors
import dev.syncended.kube.styling.Selectors
import dev.syncended.kube.styling.Selectors.link
import dev.syncended.kube.styling.Selectors.linkLink
import dev.syncended.kube.styling.Selectors.linkVisited
import kotlinx.css.CssBuilder
import kotlinx.css.color
import kotlinx.css.fontSize
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight
import kotlinx.css.properties.TextDecoration
import kotlinx.css.textDecoration

class Link(
  modifier: Modifier = Modifier.Modifier,
  private val color: Color? = null,
  private val textSize: Size? = null,
  private val fontSize: FontSize? = null,
  private val fontStyle: FontStyle? = null,
  private val text: String? = null,
  private val href: String? = null
) : Layout(modifier.withClass(link)) {
  override fun render() = a {
    +text.orEmpty()
    renderChild(this)
    this@Link.href?.let { href = it }
  }

  override fun applyStyling(builder: CssBuilder) {
    super.applyStyling(builder)
    color?.let { builder.color = it.toCssColor() }
    textSize?.let { builder.fontSize = it.toDimension() }
    fontSize?.let { builder.fontWeight = it.mapping }
    fontStyle?.let { builder.fontStyle = it.mapping }
  }

  companion object {
    fun styling(cssBuilder: CssBuilder) {
      cssBuilder.on(link) {
        textDecoration = TextDecoration.none
      }
      cssBuilder.on(linkLink) {
        color = Colors.black.toCssColor()
      }
      cssBuilder.on(linkVisited) {
        color = Colors.black.toCssColor()
      }
    }
  }
}