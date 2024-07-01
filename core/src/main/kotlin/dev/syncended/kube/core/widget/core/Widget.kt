package dev.syncended.kube.core.widget.core

import dev.syncended.kube.core.styling.Modifier
import dev.syncended.kube.core.styling.buildStyle
import dev.syncended.kube.core.styling.wrap
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.P
import kotlinx.html.div
import kotlinx.html.p
import kotlinx.html.style

abstract class Widget(protected val modifier: Modifier = Modifier()) {
  private var _parent: FlowContent? = null
  protected val parent: FlowContent get() = requireNotNull(_parent)

  fun attach(parent: FlowContent) {
    this._parent = parent
  }

  abstract fun render()

  fun p(classes: String? = null, block: P.() -> Unit = {}) = wrap {
    p(classes) {
      style = modifier.buildStyle()
      block.invoke(this)
    }
  }

  fun div(classes: String? = null, block: DIV.() -> Unit = {}) = wrap {
    div(classes) {
      style = modifier.buildStyle()
      block.invoke(this)
    }
  }

  private fun wrap(block: FlowContent.() -> Unit) {
    modifier.wrap(parent, block)
  }
}

abstract class Layout(modifier: Modifier = Modifier()) : Widget(modifier) {
  private val _widgets = mutableListOf<Widget>()
  val widgets: List<Widget> get() = _widgets.toList()

  fun add(widget: Widget) {
    _widgets.add(widget)
  }

  fun renderChildren(context: FlowContent) {
    widgets.forEach { renderChildren(it, context) }
  }

  fun renderChildren(children: Widget, context: FlowContent) {
    children.attach(context)
    children.render()
  }
}

fun <T : Layout> Layout.childLayout(instance: T, builder: T.() -> Unit) {
  instance.builder()
  add(instance)
}
