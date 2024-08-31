package dev.syncended.kube.core

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.P
import kotlinx.html.div
import kotlinx.html.p

abstract class Widget {
  private var _flowContent: FlowContent? = null
  private val flowContent: FlowContent get() = requireNotNull(_flowContent)

  fun render(flowContent: FlowContent) {
    _flowContent = flowContent
    render()
    _flowContent = null
  }

  fun div(vararg classes: Selector.Class, body: DIV.() -> Unit) {
    val classesStr = classes.joinToString(" ") { it.name }
    flowContent.div(classes = classesStr) { body() }
  }

  fun p(vararg classes: Selector.Class, body: P.() -> Unit) {
    val classesStr = classes.joinToString(" ") { it.name }
    flowContent.p(classes = classesStr) { body() }
  }

  protected abstract fun render()
}