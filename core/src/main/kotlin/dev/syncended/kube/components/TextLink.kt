package dev.syncended.kube.components

import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.toCssColor
import dev.syncended.kube.core.styling.styling
import dev.syncended.kube.styling.Colors
import dev.syncended.kube.styling.Selectors.link
import dev.syncended.kube.styling.Selectors.linkLink
import dev.syncended.kube.styling.Selectors.linkVisited
import kotlinx.css.color
import kotlinx.css.properties.TextDecoration
import kotlinx.css.textDecoration

class TextLink(modifier: TextLinkModifier) : AbstractText<TextLinkModifier>(modifier.withClass(link)) {
  override fun render() = a {
    +modifier.text.orEmpty()
    modifier.href?.let { href = it }
  }

  companion object {
    fun styling() {
      link.styling {
        textDecoration = TextDecoration.none
      }
      linkLink.styling {
        color = Colors.black.toCssColor()
      }
      linkVisited.styling {
        color = Colors.black.toCssColor()
      }
    }
  }
}

class TextLinkModifier : TextModifier() {
  internal var href: String? = null
}

fun TextLinkModifier.href(value: String): TextLinkModifier {
  href = value
  return this
}

