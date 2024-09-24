package dev.syncended.kube.core

import dev.syncended.kube.core.Kube.plugins
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.core.model.toCssSelector
import dev.syncended.kube.core.styling.defaultFonts
import dev.syncended.kube.styling.Fonts.jbMono
import kotlinx.css.CssBuilder

object KubeStyling {
  private val cssBuilder by lazy {
    val builder = CssBuilder()
    plugins.styling.forEach { it.apply(builder) }
    builder
  }

  private val _fonts = mutableSetOf(jbMono)
  internal val fonts: Set<Font> get() = _fonts

  private var _defaultFont = jbMono
  internal val defaultFont: Font get() = _defaultFont

  fun setDefaultFont(font: Font) {
    _defaultFont = font
    addFont(font)
  }

  fun addFont(font: Font) {
    _fonts.add(font)
  }

  fun styling(selector: Selector, build: CssBuilder.() -> Unit) {
    cssBuilder.build()
  }

  fun buildStyle(): String {
    defaultFonts()
    return cssBuilder.toString()
  }

  fun getFonts(): Set<Font> = fonts

}

fun CssBuilder.on(selector: Selector, builder: CssBuilder.() -> Unit) {
  val cssSelector = selector.toCssSelector()
  cssSelector { builder.invoke(this) }
}
