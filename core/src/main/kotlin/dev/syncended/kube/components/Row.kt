package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.styling.Selectors.row
import dev.syncended.kube.styling.styling
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.display
import kotlinx.css.flexDirection

class Row(modifier: Modifier) : Layout<Modifier>(
  modifier = modifier.withClass(row)
) {

  override fun render() = div {
    renderChild(this)
  }

  companion object {
    fun styling() = row.styling {
      display = Display.flex
      flexDirection = FlexDirection.row
    }
  }
}
