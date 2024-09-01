package dev.syncended.kube.components

import dev.syncended.kube.core.Layout

class Box : Layout() {
  override fun render() = div {
    renderChild(this)
  }
}