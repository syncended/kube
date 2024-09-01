package dev.syncended.kube.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
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

class Box(modifier: BoxModifier) : Layout<BoxModifier>(modifier.withClass(box)) {
  override fun render() = div {
    renderChild(this)
  }

  override fun applyModifierStyling(builder: CssBuilder) {
    super.applyModifierStyling(builder)
    modifier.horizontalAlignment?.let { builder.justifyContent = it.toJustifyContent() }
    modifier.verticalAlignment?.let { builder.alignItems = it.toAlignment() }
  }

  companion object {
    fun styling() = box.styling {
      display = Display.flex
    }
  }
}

class BoxModifier : Modifier() {
  var verticalAlignment: Alignment.Vertical? = null
  var horizontalAlignment: Alignment.Horizontal? = null
}

fun BoxModifier.verticalAlignment(alignment: Alignment.Vertical): BoxModifier {
  verticalAlignment = alignment
  return this
}

fun BoxModifier.horizontalAlignment(alignment: Alignment.Horizontal): BoxModifier {
  horizontalAlignment = alignment
  return this
}