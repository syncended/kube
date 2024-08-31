package dev.syncended.kube.components

import dev.syncended.kube.core.Layout
import dev.syncended.kube.styling.Selectors.column
import dev.syncended.kube.styling.styling
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.display
import kotlinx.css.flexDirection

class Column: Layout() {

  override fun render() = div(column) {
    renderChild(this)
  }

  companion object {

    fun styling() = column.styling {
      display = Display.flex
      flexDirection = FlexDirection.column
    }
  }
}
