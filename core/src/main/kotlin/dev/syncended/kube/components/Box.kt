package dev.syncended.kube.components

import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.Modifier

class Box(modifier: Modifier) : Layout<Modifier>(modifier) {
  override fun render() = div {
    renderChild(this)
  }
}