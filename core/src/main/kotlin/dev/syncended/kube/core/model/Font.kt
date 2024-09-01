package dev.syncended.kube.core.model

import kotlinx.css.FontStyle as CssFontStyle
import kotlinx.css.FontWeight as CssFontWeight

data class Font(
  val name: String,
  val resources: List<FontResource>
)

data class FontResource(
  val resourceName: String,
  val weight: FontWeight,
  val style: FontStyle
)

enum class FontStyle {
  NORMAL, ITALIC
}

enum class FontWeight {
  THIN, REGULAR, MEDIUM, BOLD
}

internal fun FontWeight.toCssFontWeight(): CssFontWeight = when (this) {
  FontWeight.REGULAR -> CssFontWeight.normal
  FontWeight.THIN -> CssFontWeight.w100
  FontWeight.MEDIUM -> CssFontWeight.w300
  FontWeight.BOLD -> CssFontWeight.bold
}

internal fun FontStyle.toCssFontStyle(): CssFontStyle = when (this) {
  FontStyle.ITALIC -> CssFontStyle.italic
  FontStyle.NORMAL -> CssFontStyle.normal
}
