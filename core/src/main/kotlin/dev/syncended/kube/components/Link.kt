package dev.syncended.kube.components

import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.toCssColor
import dev.syncended.kube.core.styling.styling
import dev.syncended.kube.styling.Colors
import dev.syncended.kube.styling.Selectors.link
import dev.syncended.kube.styling.Selectors.linkVisited
import kotlinx.css.color
import kotlinx.css.properties.TextDecoration
import kotlinx.css.textDecoration

class Link(modifier: LinkModifier) : AbstractText<LinkModifier>(modifier.withClass(link)) {
  override fun render() = a {
    +modifier.text.orEmpty()
    modifier.href?.let { href = it }
  }

  companion object {
    fun styling() {
      link.styling {
        textDecoration = TextDecoration.none
      }
      linkVisited.styling {
        color = Colors.black.toCssColor()
      }
    }
  }
}

class LinkModifier : TextModifier() {
  var href: String? = null
}

fun LinkModifier.href(value: String): LinkModifier {
  href = value
  return this
}

