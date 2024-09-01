package dev.syncended.kube.core

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.P
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.p

abstract class Widget<M : Modifier>(protected val modifier: M) {
  private var _flowContent: FlowContent? = null
  private val flowContent: FlowContent get() = requireNotNull(_flowContent)

  fun render(flowContent: FlowContent) {
    _flowContent = flowContent
    render()
    _flowContent = null
  }

  fun div(body: DIV.() -> Unit) {
    flowContent.div(classes = buildClasses()) {
      applyModifier()
      body()
    }
  }

  fun p(body: P.() -> Unit) {
    flowContent.p(classes = buildClasses()) {
      applyModifier()
      body()
    }
  }

  protected abstract fun render()

  private fun CommonAttributeGroupFacade.applyModifier() {
    modifier.id?.let { id = it.name }
  }

  private fun buildClasses(): String? {
    if (modifier.classes.isEmpty()) return null
    return modifier.classes.joinToString(" ") { it.name }
  }
}

