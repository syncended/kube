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

class CenterHorizontalLayout(modifier: Modifier) : Layout(modifier) {

  override fun render(parent: FlowContent) {
    parent.div(Design.Class.CENTER_HORIZONTAL) {
      style = modifier.buildStyle()
      renderChildren(this)
    }
  }
}

fun Layout.centerHorizontal(
  modifier: Modifier = modifier(),
  builder: CenterHorizontalLayout.() -> Unit
) = childLayout(CenterHorizontalLayout(modifier), builder)