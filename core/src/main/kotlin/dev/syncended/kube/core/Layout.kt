package dev.syncended.kube.core

import kotlinx.html.FlowContent

abstract class Layout : Widget() {
  private val _child = mutableListOf<Widget>()
  protected val child: List<Widget> get() = _child

  fun addChild(child: Widget) {
    _child.add(child)
  }

  protected fun renderAll(flowContent: FlowContent) {
    _child.forEach { it.render(flowContent) }
  }
}