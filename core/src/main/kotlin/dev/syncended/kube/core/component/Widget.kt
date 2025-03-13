package dev.syncended.kube.core.component

import dev.syncended.kube.core.Kube.plugins
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors.dynamicDesktop
import dev.syncended.kube.styling.Selectors.dynamicMobile
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.blockquote
import kotlinx.css.display
import kotlinx.html.A
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.FORM
import kotlinx.html.FlowContent
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.IMG
import kotlinx.html.INPUT
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.InputType
import kotlinx.html.P
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.img
import kotlinx.html.input
import kotlinx.html.p
import kotlinx.html.style

abstract class Widget(protected val modifier: Modifier) {
  private var _flowContent: FlowContent? = null
  protected val flowContent: FlowContent get() = requireNotNull(_flowContent)

  fun render(flowContent: FlowContent) {
    _flowContent = flowContent
    render()
    _flowContent = null
  }

  protected fun div(body: DIV.() -> Unit) {
    flowContent.div(classes = buildClasses()) {
      applyModifierAttributes()
      body()
    }
  }

  protected fun p(body: P.() -> Unit) {
    flowContent.p(classes = buildClasses()) {
      applyModifierAttributes()
      body()
    }
  }

  protected fun a(body: A.() -> Unit) {
    flowContent.a(classes = buildClasses()) {
      applyModifierAttributes()
      body()
    }
  }

  protected fun img(body: IMG.() -> Unit) {
    flowContent.img(classes = buildClasses()) {
      applyModifierAttributes()
      body()
    }
  }

  protected fun form(
    action: String?,
    encType: FormEncType?,
    method: FormMethod?,
    body: FORM.() -> Unit
  ) = flowContent.form(
    action = action,
    encType = encType,
    method = method,
    classes = buildClasses(),
  ) {
    applyModifierAttributes()
    body()
  }

  protected fun input(
    type: InputType?,
    formEncType: InputFormEncType?,
    formMethod: InputFormMethod?,
    name: String?,
    body: INPUT.() -> Unit
  ) = flowContent.input(
    type = type,
    formEncType = formEncType,
    formMethod = formMethod,
    name = name,
    classes = buildClasses(),
    block = body
  )

  protected abstract fun render()

  protected open fun CommonAttributeGroupFacade.applyModifierAttributes() {
    plugins.modifierAttributes.forEach { it.apply(modifier, this) }
    buildStyling()?.let { style = it }
  }

  protected open fun applyStyling(builder: CssBuilder) {
  }

  private fun buildClasses(): String? {
    if (modifier.classes.isEmpty()) return null
    return modifier.classes.joinToString(" ") { it.name }
  }

  private fun buildStyling(): String? {
    val builder = CssBuilder()
    plugins.modifierStyling.forEach { it.apply(modifier, builder) }
    applyStyling(builder)
    return builder.toString()
      .trim().takeIf { it.isNotEmpty() }
  }

  companion object {
    fun styling(cssBuilder: CssBuilder) {
      cssBuilder.on(dynamicDesktop) {
        media("screen and (max-width: 475px)") {
          display = Display.none
        }
      }
      cssBuilder.on(dynamicMobile) {
        media("screen and (min-width: 476px)") {
          display = Display.none
        }
      }
    }
  }
}

