package dev.syncended.kube.components

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.core.model.FontStyle
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.core.model.toCssColor
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Colors
import dev.syncended.kube.styling.Selectors.link
import dev.syncended.kube.styling.Selectors.linkLink
import dev.syncended.kube.styling.Selectors.linkVisited
import kotlinx.css.CssBuilder
import kotlinx.css.color
import kotlinx.css.properties.TextDecoration
import kotlinx.css.textDecoration

class TextLink(
  modifier: Modifier = Modifier,
  color: Color? = null,
  textSize: Size? = null,
  fontSize: FontSize? = null,
  fontStyle: FontStyle? = null,
  private val text: String? = null,
  private val href: String? = null
) : AbstractText(
  modifier = modifier.withClass(link),
  color = color,
  textSize = textSize,
  fontSize = fontSize,
  fontStyle = fontStyle
) {
  override fun render() = a {
    +text.orEmpty()
    this@TextLink.href?.let { href = it }
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
