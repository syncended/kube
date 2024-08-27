package dev.syncended.kube.core

abstract class Layout: Widget() {
  private val _child = mutableListOf<Widget>()
  protected val child: List<Widget> get() = _child

  fun addChild(child: Widget) {
    _child.add(child)
  }
}