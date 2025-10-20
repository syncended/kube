package dev.syncended.kube.components.layout

import com.sun.tools.javac.jvm.Code.width
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
import kotlinx.css.overflow
import kotlinx.css.width
import javax.swing.Spring.width

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
    fun styling(cssBuilder: CssBuilder) {
      cssBuilder.on(Selectors.row) {
        display = Display.flex
        flexDirection = FlexDirection.row
        overflow = Overflow.hidden
      }
      cssBuilder.on(Selectors.row.appendName(" ${withWeight.toRawSelector()}")) {
        width = LinearDimension.auto
      }
    }
  }
}