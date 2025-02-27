package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.styling.Selectors

class Link(
  modifier: Modifier = Modifier.Modifier,
  private val href: String? = null
) : Layout(modifier.withClass(Selectors.link)) {
  override fun render() = a {
    renderChild(this)
    this@Link.href?.let { href = it }
  }
}