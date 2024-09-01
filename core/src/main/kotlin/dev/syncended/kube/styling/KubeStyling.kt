package dev.syncended.kube.styling

import dev.syncended.kube.components.Column
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.Selector
import kotlinx.css.CssBuilder

object KubeStyling {
  private var selectors = mutableSetOf<Selector>()
  private val cssBuilder = CssBuilder()

  init {
    applyDefaultStyling()
  }

  fun styling(selector: Selector, build: CssBuilder.() -> Unit) {
    if (selector in selectors) return
    selectors += selector
    cssBuilder.build()
  }

  internal fun buildStyle(): String {
    return cssBuilder.toString()
  }

  private fun applyDefaultStyling() {
    defaultStyling()
    Column.styling()
    Row.styling()
  }
}

internal fun Selector.styling(builder: CssBuilder.() -> Unit) {
  KubeStyling.styling(this) {
    val selector = toCssSelector()
    selector { builder.invoke(this) }
  }
}