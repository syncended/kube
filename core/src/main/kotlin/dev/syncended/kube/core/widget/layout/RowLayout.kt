package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.widget.core.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.FlowContent
import kotlinx.html.div

class RowLayout : Layout() {
  override fun render(parent: FlowContent) {
    parent.div(Design.Class.INLINE) {
      widgets.forEach { it.render(this) }
    }
  }
}

fun Layout.row(builder: RowLayout.() -> Unit) = childLayout(RowLayout(), builder)