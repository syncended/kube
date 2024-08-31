package dev.syncended.kube.core

import kotlinx.css.LinearDimension

sealed class Size(private val units: String) {
  abstract val value: Any

  data class Px(override val value: Int) : Size("px")
  data class Rem(override val value: Double) : Size("rem")
  data class Em(override val value: Double) : Size("em")
  data class Percent(override val value: Int) : Size("%")

  internal fun toDimension(): LinearDimension {
    return LinearDimension(toRawValue())
  }

  private fun toRawValue(): String = "$value$units"
}

val Int.px: Size.Px get() = Size.Px(this)
val Int.percent: Size.Percent get() = Size.Percent(this)
val Double.rm: Size.Rem get() = Size.Rem(this)
val Int.rm: Size.Rem get() = this.toDouble().rm
val Double.em: Size.Em get() = Size.Em(this)
val Int.em: Size.Em get() = this.toDouble().em
