package dev.syncended.kube.components

import dev.syncended.kube.core.Layout
import dev.syncended.kube.styling.Selectors.row
import dev.syncended.kube.styling.styling
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.display
import kotlinx.css.flexDirection

class Row : Layout() {
  override fun render() = div(row) {
    renderChild(this)
  }

  companion object {
    fun styling() = row.styling {
      display = Display.flex
      flexDirection = FlexDirection.row
    }
  }
}