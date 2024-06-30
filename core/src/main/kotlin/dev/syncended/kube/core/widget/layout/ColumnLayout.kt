package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.FlowContent
import kotlinx.html.div

class ColumnLayout : Layout() {
  override fun render(parent: FlowContent) {
    parent.div {
      widgets.forEach {
        div {
          it.render(this)
        }
      }
    }
  }
}

fun Layout.column(builder: ColumnLayout.() -> Unit) = childLayout(ColumnLayout(), builder)

