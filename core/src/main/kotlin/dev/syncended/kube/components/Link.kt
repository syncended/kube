package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.DeprModifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.styling.Selectors.link

class Link(modifier: LinkModifier) : Layout<LinkModifier>(modifier.withClass(link)) {
  override fun render() = a {
    renderChild(this)
    modifier.href?.let { href = it }
  }
}

class LinkModifier : DeprModifier() {
  internal var href: String? = null
}

fun LinkModifier.href(value: String): LinkModifier {
  href = value
  return this
}
