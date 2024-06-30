package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.styling.modifier
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.FlowContent

class FlatLayout : Layout(modifier()) {
  override fun render(parent: FlowContent) {
    widgets.forEach { widget ->
      widget.render(parent)
    }
  }
}

fun Layout.flatLayout(builder: FlatLayout.() -> Unit) = childLayout(FlatLayout(), builder)