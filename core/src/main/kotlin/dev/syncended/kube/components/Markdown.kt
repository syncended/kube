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
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.Widget
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

  private companion object {
    val options = MutableDataSet().apply {
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
    val parser = Parser.builder(options).build()
    val htmlRenderer = HtmlRenderer.builder(options).build()
  }
}