package dev.syncended.kube.core.widget.core

import dev.syncended.kube.core.styling.Modifier
import kotlinx.html.FlowContent

abstract class Widget(protected val modifier: Modifier = Modifier()) {
  abstract fun render(parent: FlowContent)
}

abstract class Layout(modifier: Modifier = Modifier()) : Widget(modifier) {
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
