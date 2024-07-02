package dev.syncended.kube.core.styling

import dev.syncended.kube.core.widget.core.Fonts
import dev.syncended.kube.core.widget.core.alignBottom
import dev.syncended.kube.core.widget.core.alignCenter
import dev.syncended.kube.core.widget.core.alignTop
import dev.syncended.kube.core.widget.core.all
import dev.syncended.kube.core.widget.core.gravityCenter
import dev.syncended.kube.core.widget.core.gravityStart
import dev.syncended.kube.core.widget.core.gravityEnd
import dev.syncended.kube.core.widget.core.inline
import kotlinx.css.Align
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FontStyle
import kotlinx.css.FontWeight
import kotlinx.css.JustifyContent
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.alignContent
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

  gravityCenter {
    width = LinearDimension("100%")
    display = Display.flex
    justifyContent = JustifyContent.center
    alignContent = Align.center
  }

  gravityStart {
    width = LinearDimension("100%")
    display = Display.flex
    justifyContent = JustifyContent.start
    alignContent = Align.start
  }

  gravityEnd {
    width = LinearDimension("100%")
    display = Display.flex
    justifyContent = JustifyContent.end
    alignContent = Align.end
  }

  alignCenter {
    display = Display.flex
    alignItems = Align.center
  }

  alignTop {
    display = Display.flex
    alignItems = Align.start
  }

  alignBottom {
    display = Display.flex
    alignItems = Align.end
  }
}