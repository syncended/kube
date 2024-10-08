package dev.syncended.kube.components

import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension
import com.vladsch.flexmark.ext.autolink.AutolinkExtension
import com.vladsch.flexmark.ext.definition.DefinitionExtension
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension
import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.ext.typographic.TypographicExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.data.MutableDataSet
import dev.syncended.kube.core.Kube.settings
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.px
import dev.syncended.kube.core.model.toCssColor
import dev.syncended.kube.core.on
import dev.syncended.kube.styling.Selectors.preCode
import dev.syncended.kube.styling.Selectors.preWithCode
import dev.syncended.kube.styling.Size.percent100
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.Flex
import kotlinx.css.FlexWrap
import kotlinx.css.LinearDimension
import kotlinx.css.Overflow
import kotlinx.css.Padding
import kotlinx.css.Position
import kotlinx.css.backgroundColor
import kotlinx.css.borderRadius
import kotlinx.css.display
import kotlinx.css.flex
import kotlinx.css.flexWrap
import kotlinx.css.overflowX
import kotlinx.css.overflowY
import kotlinx.css.padding
import kotlinx.css.position
import kotlinx.css.width
import kotlinx.html.unsafe

class Markdown(
  private val markdown: String,
  modifier: Modifier
) : Widget(modifier) {
  override fun render() = div {
    unsafe {
      val body = parser.parse(markdown)
      +htmlRenderer.render(body)
    }
  }

  companion object {
    private val options = MutableDataSet().apply {
      set(
        Parser.EXTENSIONS, listOf(
          AutolinkExtension.create(),
          AbbreviationExtension.create(),
          DefinitionExtension.create(),
          FootnoteExtension.create(),
          TablesExtension.create(),
          TypographicExtension.create()
        )
      )
      set(HtmlRenderer.SOFT_BREAK, "<br/>")
    }
    private val parser = Parser.builder(options).build()
    private val htmlRenderer = HtmlRenderer.builder(options).build()

    fun styling(cssBuilder: CssBuilder) {
      cssBuilder.on(preWithCode) {
        display = Display.flex
        width = percent100.toDimension()
//        flexWrap = FlexWrap.nowrap
        backgroundColor = settings.styling.codeBlockBackground.toCssColor()
        borderRadius = settings.styling.codeBlockBorderRadius.toDimension()
        padding = Padding(settings.styling.codeBlockPadding.toDimension())
      }
      cssBuilder.on(preCode) {
        overflowX = Overflow.auto
      }
    }
  }
}