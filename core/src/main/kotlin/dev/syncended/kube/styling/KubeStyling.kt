package dev.syncended.kube.styling

import dev.syncended.kube.components.Column
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.styling.Fonts.jbMono
import kotlinx.css.CssBuilder

object KubeStyling {
  private var selectors = mutableSetOf<Selector>()
  private val cssBuilder = CssBuilder()
  private val fonts = mutableListOf(jbMono)

  init {
    applyDefaultStyling()
  }

  fun styling(selector: Selector, build: CssBuilder.() -> Unit) {
    if (selector in selectors) return
    selectors += selector
    cssBuilder.build()
  }

  internal fun buildStyle(): String {
    defaultStyling()
    defaultFonts(fonts)
    return cssBuilder.toString()
  }

  private fun applyDefaultStyling() {
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