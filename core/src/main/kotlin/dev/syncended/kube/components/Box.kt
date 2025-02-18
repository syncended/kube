package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.core.model.toJustifyContent
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors.box
import dev.syncended.kube.styling.Selectors.boxChild
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.Position
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.justifyContent
import kotlinx.css.position

abstract class AbstractBox(
  modifier: Modifier,
  private val verticalAlignment: Alignment.Vertical?,
  private val horizontalAlignment: Alignment.Horizontal?,
) : Layout(modifier) {
  override fun render() = div {
    renderChild(this)
  }

  override fun applyStyling(builder: CssBuilder) {
    super.applyStyling(builder)
    horizontalAlignment?.let { builder.justifyContent = it.toJustifyContent() }
    verticalAlignment?.let { builder.alignItems = it.toAlignment() }
  }
}

class Box(
  modifier: Modifier = Modifier,
  verticalAlignment: Alignment.Vertical? = null,
  horizontalAlignment: Alignment.Horizontal? = null,
) : AbstractBox(
  modifier = modifier.withClass(box),
  verticalAlignment = verticalAlignment,
  horizontalAlignment = horizontalAlignment
) {

  companion object {
    fun styling(cssBuilder: CssBuilder) {
      cssBuilder.on(box) {
        display = Display.flex
        position = Position.relative
      }
      cssBuilder.on(boxChild) {
        position = Position.absolute
      }
    }
  }
}
