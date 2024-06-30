package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.buildStyle
import dev.syncended.kube.core.styling.modifier
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.style

class ColumnLayout(modifier: Modifier) : Layout(modifier) {
  override fun render(parent: FlowContent) {
    parent.div {
      style = modifier.buildStyle()
      widgets.forEach {
        div {
          it.render(this)
        }
      }
    }
  }
}


fun Layout.column(
  modifier: Modifier = modifier(),
  builder: ColumnLayout.() -> Unit
) = childLayout(ColumnLayout(modifier), builder)

