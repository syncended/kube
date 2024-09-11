package dev.syncended.kube.core.styling

import dev.syncended.kube.components.Box
import dev.syncended.kube.components.Card
import dev.syncended.kube.components.Column
import dev.syncended.kube.components.TextLink
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.styling.Fonts
import dev.syncended.kube.styling.Fonts.jbMono
import kotlinx.css.CssBuilder

object KubeStyling {
  private var selectors = mutableSetOf<Selector>()
  private val cssBuilder = CssBuilder()

  private val _fonts = mutableSetOf(jbMono)
  internal val fonts: Set<Font> get() = _fonts

  private var _defaultFont = jbMono
  internal val defaultFont: Font get() = _defaultFont

  init {
    applyDefaultStyling()
  }

  fun setDefaultFont(font: Font) {
    _defaultFont = font
    addFont(font)
  }

  fun addFont(font: Font) {
    _fonts.add(font)
  }

  fun styling(selector: Selector, build: CssBuilder.() -> Unit) {
    if (selector in selectors) return
    selectors += selector
    cssBuilder.build()
  }

  fun buildStyle(): String {
    defaultStyling()
    defaultFonts()
    return cssBuilder.toString()
  }

  fun getFonts(): Set<Font> = fonts

  private fun applyDefaultStyling() {
    Box.styling()
    Card.styling()
    Column.styling()
    Row.styling()
    TextLink.styling()
    Widget.styling()
  }
}

internal fun Selector.styling(builder: CssBuilder.() -> Unit) {
  KubeStyling.styling(this) {
    val selector = toCssSelector()
    selector { builder.invoke(this) }
  }
}