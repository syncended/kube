package dev.syncended.kube.core.component

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.model.toCssColor
import dev.syncended.kube.core.styling.styling
import dev.syncended.kube.styling.Selectors.dynamicDesktop
import dev.syncended.kube.styling.Selectors.dynamicMobile
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.backgroundColor
import kotlinx.css.borderBottomLeftRadius
import kotlinx.css.borderBottomRightRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.display
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
import kotlinx.html.A
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.IMG
import kotlinx.html.P
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.style

abstract class Widget(protected val modifier: Modifier) {
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

  fun a(body: A.() -> Unit) {
    flowContent.a(classes = buildClasses()) {
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

  protected open fun applyStyling(builder: CssBuilder) {
    Kube.modifierStylingPlugins.forEach { it.apply(modifier, builder) }
  }

  private fun buildClasses(): String? {
    if (modifier.classes.isEmpty()) return null
    return modifier.classes.joinToString(" ") { it.name }
  }

  private fun buildStyling(): String? {
    val builder = CssBuilder()
    applyStyling(builder)
    return builder.toString()
      .trim().takeIf { it.isNotEmpty() }
  }

  companion object {
    fun styling() {
      dynamicDesktop.styling {
        media("screen and (max-width: 475px)") {
          display = Display.none
        }
      }
      dynamicMobile.styling {
        media("screen and (min-width: 476px)") {
          display = Display.none
        }
      }
    }
  }
}

