package dev.syncended.kube.core.plugins

import dev.syncended.kube.components.Box
import dev.syncended.kube.components.Card
import dev.syncended.kube.components.Column
import dev.syncended.kube.components.Row
import dev.syncended.kube.components.TextLink
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.KubeStyling
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors.all
import dev.syncended.kube.styling.Selectors.body
import dev.syncended.kube.styling.Selectors.html
import dev.syncended.kube.styling.Size.percent100
import dev.syncended.kube.styling.Size.rem0
import kotlinx.css.BoxSizing
import kotlinx.css.CssBuilder
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.UserSelect
import kotlinx.css.boxSizing
import kotlinx.css.fontFamily
import kotlinx.css.height
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.userSelect
import kotlinx.css.width

object StylingPlugin : KubePlugin.Styling {
  override fun apply(cssBuilder: CssBuilder) {
    widgetStyling(cssBuilder)
    rawStyling(cssBuilder)
  }

  private fun widgetStyling(cssBuilder: CssBuilder) {
    Box.styling(cssBuilder)
    Card.styling(cssBuilder)
    Column.styling(cssBuilder)
    Row.styling(cssBuilder)
    TextLink.styling(cssBuilder)
    Widget.styling(cssBuilder)
  }

  private fun rawStyling(cssBuilder: CssBuilder) {
    cssBuilder.on(all) {
      width = LinearDimension.fitContent
      height = LinearDimension.fitContent
      boxSizing = BoxSizing.borderBox
      padding = Padding(rem0.toDimension())
      margin = Margin(rem0.toDimension())
      userSelect = UserSelect.none
      fontFamily = KubeStyling.defaultFont.name
    }
    cssBuilder.on(html) {
      width = percent100.toDimension()
      height = percent100.toDimension()
    }
    cssBuilder.on(body) {
      width = percent100.toDimension()
      height = percent100.toDimension()
    }
  }
}