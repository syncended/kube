package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.appendName
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors
import dev.syncended.kube.styling.Selectors.withWeight
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.LinearDimension
import kotlinx.css.Overflow
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.height
import kotlinx.css.overflow
import kotlinx.css.width

class Column(
  modifier: Modifier = Modifier.Modifier,
  private val alignment: Alignment.Horizontal? = null,
) : Layout(modifier.withClass(Selectors.column)) {

  override fun render() = div {
    renderChild(this)
  }

  override fun applyStyling(builder: CssBuilder) {
    super.applyStyling(builder)
    alignment?.let { builder.alignItems = it.toAlignment() }
  }

  companion object {
    fun styling(cssBuilder: CssBuilder) {
      cssBuilder.on(Selectors.column) {
        display = Display.flex
        flexDirection = FlexDirection.column
        overflow = Overflow.hidden
      }
      cssBuilder.on(Selectors.row.appendName(" ${withWeight.toRawSelector()}")) {
        height = LinearDimension.auto
      }
    }
  }
}