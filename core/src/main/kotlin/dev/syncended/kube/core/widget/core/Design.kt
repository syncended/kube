package dev.syncended.kube.core.widget.core

import kotlinx.css.LinearDimension

object Design {

  object Size {
    const val MAX_WIDTH = 600
  }

  object Class {
    const val TEXT = "text"
    const val INLINE = "inline"
    const val GRAVITY_START = "gravity-start"
    const val GRAVITY_CENTER = "gravity-center"
    const val GRAVITY_END = "gravity-end"
  }

  object Font {
    const val REGULAR = "jb-regular"
  }
}

val Int.px: LinearDimension get() = LinearDimension("${this}px")
val Int.percent: LinearDimension get() = LinearDimension("${this}%")