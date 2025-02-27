package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.flexDirection

class Row(
  modifier: Modifier = Modifier.Modifier,
  private val alignment: Alignment.Vertical? = null
) : Layout(modifier.withClass(Selectors.row)) {

  override fun render() = div {
    renderChild(this)
  }

  override fun applyStyling(builder: CssBuilder) {
    super.applyStyling(builder)
    alignment?.let { builder.alignItems = it.toAlignment() }
  }

  companion object {
    fun styling(cssBuilder: CssBuilder) = cssBuilder.on(Selectors.row) {
      display = Display.flex
      flexDirection = FlexDirection.row
    }
  }
}