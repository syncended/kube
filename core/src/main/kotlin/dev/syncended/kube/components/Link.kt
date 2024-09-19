package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.styling.Selectors.link

class Link(
  modifier: Modifier = Modifier,
  private val href: String? = null
) : Layout(modifier.withClass(link)) {
  override fun render() = a {
    renderChild(this)
    this@Link.href?.let { href = it }
  }
}
