package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.styling.Selectors.row
import dev.syncended.kube.core.styling.styling
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.justifyContent

class Row(modifier: RowModifier) : Layout<RowModifier>(
  modifier = modifier.withClass(row)
) {

  override fun render() = div {
    renderChild(this)
  }

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    modifier.alignment?.let { builder.alignItems = it.toAlignment() }
  }

  companion object {
    fun styling() = row.styling {
      display = Display.flex
      flexDirection = FlexDirection.row
    }
  }
}

class RowModifier : Modifier() {
  internal var alignment: Alignment.Vertical? = null
}

fun RowModifier.align(alignment: Alignment.Vertical): RowModifier {
  this.alignment = alignment
  return this
}
