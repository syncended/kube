package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.div

class ColumnLayout(modifier: Modifier) : Layout(modifier) {
  override fun render() {
    div {
      widgets.forEach { child ->
        div { renderChildren(child, this) }
      }
    }
  }
}


fun Layout.column(
  modifier: Modifier = Modifier(),
  builder: ColumnLayout.() -> Unit
) = childLayout(ColumnLayout(modifier), builder)

