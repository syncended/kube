package dev.syncended.kube.core.model

import kotlinx.css.TagSelector

sealed class Selector {

  data class Class(
    val name: String
  ) : Selector()

  data class Id(
    val name: String
  ) : Selector()

  data class Tag(
    val name: String
  ) : Selector()

  data class Raw(
    val value: String
  ) : Selector()

  fun toRawSelector(): String {
    return when (this) {
      is Class -> ".$name"
      is Id -> "#$name"
      is Tag -> name
      is Raw -> value
    }
  }
}

fun String.toClassSelector(): Selector.Class {
  return Selector.Class(this)
}

fun String.toIdSelector(): Selector.Id {
  return Selector.Id(this)
}

fun String.toTagSelector(): Selector.Tag {
  return Selector.Tag(this)
}

fun String.toRawSelector(): Selector.Raw {
  return Selector.Raw(this)
}

infix fun Selector.Class.appendName(appendName: String): Selector.Class {
  return this.copy(name = name + appendName)
}

infix fun Selector.child(child: Selector): Selector.Raw {
  return Selector.Raw("${toRawSelector()} ${child.toRawSelector()}")
}

internal fun Selector.toCssSelector(): TagSelector {
  return TagSelector(this.toRawSelector())
}
