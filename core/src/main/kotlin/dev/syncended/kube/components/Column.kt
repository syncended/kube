package dev.syncended.kube.components

import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.styling.Selectors.column
import dev.syncended.kube.styling.styling
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.flexDirection

class Column(modifier: ColumnModifier) : Layout<ColumnModifier>(
  modifier = modifier.withClass(column)
) {

  override fun render() = div {
    renderChild(this)
  }

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    builder.alignItems = modifier.alignment.toAlignment()
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
  var alignment: Alignment.Horizontal = Alignment.Horizontal.Start
}

fun ColumnModifier.align(alignment: Alignment.Horizontal): ColumnModifier {
  this.alignment = alignment
  return this
}
