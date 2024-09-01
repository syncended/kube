package dev.syncended.kube.core

import kotlinx.css.CssBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.P
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.p
import kotlinx.html.style

abstract class Widget<M : Modifier>(val modifier: M) {
  private var _flowContent: FlowContent? = null
  private val flowContent: FlowContent get() = requireNotNull(_flowContent)

  fun render(flowContent: FlowContent) {
    _flowContent = flowContent
    render()
    _flowContent = null
  }

  fun div(body: DIV.() -> Unit) {
    flowContent.div(classes = buildClasses()) {
      applyModifierAttributes()
      body()
    }
  }

  fun p(body: P.() -> Unit) {
    flowContent.p(classes = buildClasses()) {
      applyModifierAttributes()
      body()
    }
  }

  protected abstract fun render()

  protected open fun CommonAttributeGroupFacade.applyModifierAttributes() {
    modifier.id?.let { id = it.name }
    buildStyling()?.let { style = it }
  }

  protected open fun applyModifierStyling(builder: CssBuilder) {
  }

  private fun buildClasses(): String? {
    if (modifier.classes.isEmpty()) return null
    return modifier.classes.joinToString(" ") { it.name }
  }

  private fun buildStyling(): String? {
    val builder = CssBuilder()
    applyModifierStyling(builder)
    return builder.toString()
      .trim().takeIf { it.isNotEmpty() }
  }
}

