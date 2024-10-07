package dev.syncended.kube.core.plugins

import dev.syncended.kube.components.Box
import dev.syncended.kube.components.Card
import dev.syncended.kube.components.Column
import dev.syncended.kube.components.Row
import dev.syncended.kube.components.TextLink
import dev.syncended.kube.core.Kube.settings
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.model.url
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
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight
import kotlinx.css.height
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.src
import kotlinx.css.userSelect
import kotlinx.css.width
import loadResourceBase64

object KubeStylingPlugin : KubePlugin.Styling {
  private const val FONT_URL_TEMPLATE = "url(%s) format(woff2)"
  private const val FONT_BASE_64_TEMPLATE = "url(data:font/truetype;charset=utf-8;base64,%s) format('truetype')"

  override fun apply(cssBuilder: CssBuilder) {
    widgetStyling(cssBuilder)
    rawStyling(cssBuilder)
    fonts(cssBuilder)
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
      settings.fonts.defaultFont?.name?.let { fontFamily = it }
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

  private fun fonts(cssBuilder: CssBuilder) {
    settings.fonts.fonts.forEach { fontStyling(it, cssBuilder) }
  }

  private fun fontStyling(font: Font, cssBuilder: CssBuilder) {
    font.resources.forEach { resource ->
      cssBuilder.fontFace {
        src = when (settings.resources.mode) {
          ResourceMode.FAT -> {
            val base64 = loadResourceBase64(resource.resourceName)
            FONT_BASE_64_TEMPLATE.format(base64)
          }

          ResourceMode.LINK -> FONT_URL_TEMPLATE.format(resource.url)
        }
        fontFamily = font.name
        fontWeight = resource.size.mapping
        fontStyle = resource.style.mapping
      }
    }
  }
}