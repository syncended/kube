package dev.syncended.kube.core.model

import kotlinx.css.Align

sealed class Alignment {
  sealed class Vertical : Alignment() {
    data object Start : Vertical()
    data object Center : Vertical()
    data object End : Vertical()
  }

  sealed class Horizontal : Alignment() {
    data object Start : Horizontal()
    data object Center : Horizontal()
    data object End : Horizontal()
  }
}

internal fun Alignment.Horizontal.toAlignment(): Align {
  return when (this) {
    Alignment.Horizontal.Start -> Align.start
    Alignment.Horizontal.Center -> Align.center
    Alignment.Horizontal.End -> Align.end
  }
}

internal fun Alignment.Vertical.toAlignment(): Align {
  return when (this) {
    Alignment.Vertical.Start -> Align.start
    Alignment.Vertical.Center -> Align.center
    Alignment.Vertical.End -> Align.end
  }
}
