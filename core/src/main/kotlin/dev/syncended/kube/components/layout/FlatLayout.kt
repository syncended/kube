package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

class FlatLayout : Layout(Modifier) {
  override fun render() = renderChild(flowContent)
}