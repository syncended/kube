package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

class Box(modifier: Modifier) : Layout<Modifier>(modifier) {
  override fun render() = div {
    renderChild(this)
  }
}