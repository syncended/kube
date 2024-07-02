package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout

class RowLayout(modifier: Modifier) : Layout(modifier) {
  override fun render() {
    div(Design.Class.INLINE) { renderChildren(this) }
  }
}

fun Layout.row(
  modifier: Modifier = Modifier(),
  builder: RowLayout.() -> Unit
) = childLayout(RowLayout(modifier), builder)