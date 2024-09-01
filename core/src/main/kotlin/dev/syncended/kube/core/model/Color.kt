package dev.syncended.kube.core.model

import kotlinx.css.Color as CssColor

data class Color(
  val value: String
)

fun String.toColor(): Color = Color(this)

internal fun Color.toCssColor(): CssColor {
  return CssColor(value)
}