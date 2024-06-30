package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.buildStyle
import dev.syncended.kube.core.styling.modifier
import dev.syncended.kube.core.widget.core.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.style

class RowLayout(modifier: Modifier) : Layout(modifier) {
  override fun render(parent: FlowContent) {
    parent.div(Design.Class.INLINE) {
      style = modifier.buildStyle()
      widgets.forEach { it.render(this) }
    }
  }
}

fun Layout.row(
  modifier: Modifier = modifier(),
  builder: RowLayout.() -> Unit
) = childLayout(RowLayout(modifier), builder)