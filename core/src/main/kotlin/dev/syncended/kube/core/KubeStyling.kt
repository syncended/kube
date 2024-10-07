package dev.syncended.kube.core

import dev.syncended.kube.core.Kube.plugins
import dev.syncended.kube.core.Kube.settings
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.core.model.toCssSelector
import kotlinx.css.CssBuilder

object KubeStyling {
  private val cssBuilder by lazy {
    val builder = CssBuilder()
    plugins.styling.forEach { it.apply(builder) }
    builder
  }

  fun buildStyle(): String {
    return cssBuilder.toString()
  }

  fun getFonts(): Set<Font> = settings.fonts.fonts.toSet()
}

fun CssBuilder.on(selector: Selector, builder: CssBuilder.() -> Unit) {
  val cssSelector = selector.toCssSelector()
  cssSelector { builder.invoke(this) }
}
