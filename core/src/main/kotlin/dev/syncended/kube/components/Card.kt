package dev.syncended.kube.components

import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.styling.styling
import dev.syncended.kube.styling.Selectors.card
import dev.syncended.kube.styling.Size.rem1
import kotlinx.css.Display
import kotlinx.css.borderBottomLeftRadius
import kotlinx.css.borderBottomRightRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.display

class Card(modifier: BoxModifier) : AbstractBox<BoxModifier>(modifier.withClass(card)) {
  companion object {
    fun styling() = card.styling {
      display = Display.flex

      borderTopLeftRadius = rem1.toDimension()
      borderTopRightRadius = rem1.toDimension()
      borderBottomLeftRadius = rem1.toDimension()
      borderBottomRightRadius = rem1.toDimension()
    }
  }
}
