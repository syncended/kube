package dev.syncended.kube.core.widget.core

import kotlinx.html.FlowContent

abstract class Widget {
  abstract fun render(parent: FlowContent)
}

abstract class Layout : Widget() {
  private val _widgets = mutableListOf<Widget>()
  val widgets: List<Widget> get() = _widgets.toList()

  fun add(widget: Widget) {
    _widgets.add(widget)
  }

  fun renderChildren(context: FlowContent) {
    widgets.forEach { it.render(context) }
  }
}

fun <T : Layout> Layout.childLayout(instance: T, builder: T.() -> Unit) {
  instance.builder()
  add(instance)
}
