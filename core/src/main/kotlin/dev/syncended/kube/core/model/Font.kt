package dev.syncended.kube.core.model

import kotlinx.css.FontWeight
import kotlinx.css.FontStyle as CssFontStyle

data class Font(
  val name: String,
  val resources: List<FontResource>
)

data class FontResource(
  val resourceName: String,
  val size: FontSize,
  val style: FontStyle
)

sealed class FontStyle(internal val mapping: CssFontStyle) {
  data object Normal : FontStyle(CssFontStyle.normal)
  data object Italic : FontStyle(CssFontStyle.italic)
}

sealed class FontSize(internal val mapping: FontWeight) {
  data object Thin : FontSize(FontWeight.w100)
  data object Regular : FontSize(FontWeight.normal)
  data object Medium : FontSize(FontWeight.w300)
  data object Bold : FontSize(FontWeight.bold)
}
