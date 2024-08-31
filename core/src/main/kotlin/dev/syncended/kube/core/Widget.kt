package dev.syncended.kube.core

import kotlinx.html.FlowContent

abstract class Widget {
  private var _flowContent: FlowContent? = null
  private val flowContent: FlowContent get() = requireNotNull(_flowContent)

  fun render(flowContent: FlowContent) {
    _flowContent = flowContent
    render()
    _flowContent = null
  }

  protected abstract fun render()
}