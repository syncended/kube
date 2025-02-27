package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors
import dev.syncended.kube.styling.Size
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.borderBottomLeftRadius
import kotlinx.css.borderBottomRightRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.display

class Card(
  modifier: Modifier = Modifier.Modifier,
  verticalAlignment: Alignment.Vertical? = null,
  horizontalAlignment: Alignment.Horizontal? = null,
) : AbstractBox(
  modifier = modifier.withClass(Selectors.card),
  verticalAlignment = verticalAlignment,
  horizontalAlignment = horizontalAlignment
) {
  companion object {
    fun styling(cssBuilder: CssBuilder) = cssBuilder.on(Selectors.card) {
      display = Display.flex

      borderTopLeftRadius = Size.rem1.toDimension()
      borderTopRightRadius = Size.rem1.toDimension()
      borderBottomLeftRadius = Size.rem1.toDimension()
      borderBottomRightRadius = Size.rem1.toDimension()
    }
  }
}