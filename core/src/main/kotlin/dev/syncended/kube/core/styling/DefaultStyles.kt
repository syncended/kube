package dev.syncended.kube.core.styling

import dev.syncended.kube.core.widget.core.Design
import dev.syncended.kube.core.widget.core.Fonts
import dev.syncended.kube.core.widget.core.all
import dev.syncended.kube.core.widget.core.centerHorizontal
import dev.syncended.kube.core.widget.core.inline
import dev.syncended.kube.core.widget.core.px
import kotlinx.css.Align
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FontStyle
import kotlinx.css.FontWeight
import kotlinx.css.JustifyContent
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.TextAlign
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.fontFamily
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight
import kotlinx.css.justifyContent
import kotlinx.css.margin
import kotlinx.css.p
import kotlinx.css.padding
import kotlinx.css.src
import kotlinx.css.textAlign
import kotlinx.css.width


fun webPageStyle(): String {
  return CssBuilder().apply {
    applyFonts()
    applyDefaultTags()
    applyCustomClasses()
  }.toString()
}

private fun CssBuilder.applyFonts() {
  fontFace {
    fontFamily = Design.Font.REGULAR
    src = "url(data:font/truetype;charset=utf-8;base64,${Fonts.regular()}) format('truetype');"
    fontWeight = FontWeight.normal
    fontStyle = FontStyle.normal
  }
}

private fun CssBuilder.applyDefaultTags() {
  all {
    padding = Padding(LinearDimension("0px"))
    margin = Margin(LinearDimension("0px"))
    fontFamily = Design.Font.REGULAR
  }

  p {
    display = Display.inlineBlock
  }
}

private fun CssBuilder.applyCustomClasses() {
  inline {
    display = Display.flex
  }

  centerHorizontal {
    width = LinearDimension("100%")
    display = Display.flex
    justifyContent = JustifyContent.center
    alignItems = Align.center
  }
}