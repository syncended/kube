package dev.syncended.kube.core.component

import dev.syncended.kube.core.model.toCssColor
import kotlinx.css.CssBuilder
import kotlinx.css.backgroundColor
import kotlinx.css.borderBottomLeftRadius
import kotlinx.css.borderBottomRightRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.height
import kotlinx.css.marginBottom
import kotlinx.css.marginLeft
import kotlinx.css.marginRight
import kotlinx.css.marginTop
import kotlinx.css.maxHeight
import kotlinx.css.maxWidth
import kotlinx.css.minHeight
import kotlinx.css.minWidth
import kotlinx.css.paddingBottom
import kotlinx.css.paddingLeft
import kotlinx.css.paddingRight
import kotlinx.css.paddingTop
import kotlinx.css.width
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.IMG
import kotlinx.html.P
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.img
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

  fun img(body: IMG.() -> Unit) {
    flowContent.img(classes = buildClasses()) {
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
    modifier.width?.let { builder.width = it.toDimension() }
    modifier.minWidth?.let { builder.minWidth = it.toDimension() }
    modifier.maxWidth?.let { builder.maxWidth = it.toDimension() }

    modifier.height?.let { builder.height = it.toDimension() }
    modifier.minHeight?.let { builder.minHeight = it.toDimension() }
    modifier.maxHeight?.let { builder.maxHeight = it.toDimension() }

    modifier.paddingTop?.let { builder.paddingTop = it.toDimension() }
    modifier.paddingLeft?.let { builder.paddingLeft = it.toDimension() }
    modifier.paddingRight?.let { builder.paddingRight = it.toDimension() }
    modifier.paddingBottom?.let { builder.paddingBottom = it.toDimension() }

    modifier.marginTop?.let { builder.marginTop = it.toDimension() }
    modifier.marginLeft?.let { builder.marginLeft = it.toDimension() }
    modifier.marginRight?.let { builder.marginRight = it.toDimension() }
    modifier.marginBottom?.let { builder.marginBottom = it.toDimension() }

    modifier.backgroundColor?.let { builder.backgroundColor = it.toCssColor() }
    modifier.borderTopLeftRadius?.let { builder.borderTopLeftRadius = it.toDimension() }
    modifier.borderTopRightRadius?.let { builder.borderTopRightRadius = it.toDimension() }
    modifier.borderBottomLeftRadius?.let { builder.borderBottomLeftRadius = it.toDimension() }
    modifier.borderBottomRightRadius?.let { builder.borderBottomRightRadius = it.toDimension() }
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

