package dev.syncended.kube.core

import kotlinx.css.TagSelector

sealed class Selector {

  data class Class(
    val name: String
  ) : Selector()

  data class Id(
    val name: String
  ) : Selector()

  fun toRawSelector(): String {
    return when (this) {
      is Class -> ".$name"
      is Id -> "#$name"
    }
  }

  private fun Selector.toCssSelector(): TagSelector {
    return TagSelector(this.toRawSelector())
  }
}

fun String.toClassSelector(): Selector.Class {
  return Selector.Class(this)
}

fun String.toIdSelector(): Selector.Id {
  return Selector.Id(this)
}
