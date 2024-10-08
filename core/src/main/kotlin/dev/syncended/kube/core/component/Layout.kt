package dev.syncended.kube.core.component

import kotlinx.html.FlowContent

abstract class Layout(modifier: Modifier) : Widget(modifier) {
  private val _child = mutableListOf<Widget>()
  protected val child: List<Widget> get() = _child

  fun addChild(child: Widget) {
    _child.add(child)
  }

  protected fun renderChild(flowContent: FlowContent) {
    _child.forEach { it.render(flowContent) }
  }
}
