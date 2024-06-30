package dev.syncended.kube.core.widget.layout

import dev.syncended.kube.core.widget.core.Design
import dev.syncended.kube.core.widget.core.Layout
import dev.syncended.kube.core.widget.core.childLayout
import kotlinx.html.FlowContent
import kotlinx.html.div

class CenterHorizontalLayout : Layout() {

  override fun render(parent: FlowContent) {
    parent.div(Design.Class.CENTER_HORIZONTAL) { renderChildren(this) }
  }
}

fun Layout.centerHorizontal(builder: CenterHorizontalLayout.() -> Unit) = childLayout(CenterHorizontalLayout(), builder)