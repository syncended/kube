package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.DeprModifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.toAlignment
import dev.syncended.kube.core.model.toJustifyContent
import dev.syncended.kube.core.styling.styling
import dev.syncended.kube.styling.Selectors.box
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.justifyContent

abstract class AbstractBox<M : BoxModifier>(modifier: M) : Layout<M>(modifier) {
  override fun render() = div {
    renderChild(this)
  }

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    modifier.horizontalAlignment?.let { builder.justifyContent = it.toJustifyContent() }
    modifier.verticalAlignment?.let { builder.alignItems = it.toAlignment() }
  }
}

class Box(modifier: BoxModifier) : AbstractBox<BoxModifier>(modifier.withClass(box)) {
  companion object {
    fun styling() = box.styling {
      display = Display.flex
    }
  }
}

open class BoxModifier : DeprModifier() {
  internal var verticalAlignment: Alignment.Vertical? = null
  internal var horizontalAlignment: Alignment.Horizontal? = null
}

fun <T : BoxModifier> T.verticalAlignment(alignment: Alignment.Vertical): T {
  verticalAlignment = alignment
  return this
}

fun <T : BoxModifier> T.horizontalAlignment(alignment: Alignment.Horizontal): T {
  horizontalAlignment = alignment
  return this
}