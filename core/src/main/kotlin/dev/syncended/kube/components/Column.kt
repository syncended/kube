package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.core.styling.styling
import dev.syncended.kube.styling.Selectors.column
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.LinearDimension
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.height

class Column(modifier: ColumnModifier) : Layout<ColumnModifier>(
  modifier = modifier.withClass(column)
) {

  override fun render() = div {
    renderChild(this)
  }

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    modifier.alignment?.let { builder.alignItems = it.toAlignment() }
  }

  companion object {
    fun styling() {
      column.styling {
        display = Display.flex
        flexDirection = FlexDirection.column
      }
    }
  }
}

class ColumnModifier : Modifier() {
  internal var alignment: Alignment.Horizontal? = null
}

fun ColumnModifier.align(alignment: Alignment.Horizontal): ColumnModifier {
  this.alignment = alignment
  return this
}
