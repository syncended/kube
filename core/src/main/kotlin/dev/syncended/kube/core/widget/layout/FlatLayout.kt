package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout

class FlatLayout : Layout(Modifier()) {
  override fun render() {
    renderChildren(parent)
  }
}

fun Layout.flatLayout(builder: FlatLayout.() -> Unit) = childLayout(FlatLayout(), builder)