package dev.syncended.kube.core.styling

import kotlinx.css.LinearDimension

sealed class Size {

  data class Px(val value: Int) : Size()

  data class Percent(val value: Int) : Size()
}

val Int.px: Size.Px get() = Size.Px(this)
val Int.percent: Size.Percent get() = Size.Percent(this)

fun Size.toLinearDimension(): LinearDimension {
  val rawValue = when (this) {
    is Size.Px -> "${value}px"
    is Size.Percent -> "${value}%"
  }
  return LinearDimension(rawValue)
}