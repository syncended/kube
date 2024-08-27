package dev.syncended.kube.core

import kotlinx.css.TagSelector

sealed class Selector {

  data class Class(
    val name: String
  ) : Selector()

  data class Id(
    val name: String
  ) : Selector()
}

fun String.toClassSelector(): Selector.Class {
  return Selector.Class(this)
}

fun String.toIdSelector(): Selector.Id {
  return Selector.Id(this)
}

internal fun Selector.toCssSelector(): TagSelector {
  val rawSelector = when (this) {
    is Selector.Class -> ".$name"
    is Selector.Id -> "#$name"
  }
  return TagSelector(rawSelector)
}
