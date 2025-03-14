package dev.syncended.kube.website.web.components

import dev.syncended.kube.components.layout.Card
import dev.syncended.kube.components.layout.Column
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.borderRadius
import dev.syncended.kube.core.component.fillMaxSize
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.height
import dev.syncended.kube.core.component.marginHorizontal
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.core.component.paddingHorizontal
import dev.syncended.kube.core.component.paddingVertical
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.render
import dev.syncended.kube.dsl.space
import dev.syncended.kube.styling.Size.rem05
import dev.syncended.kube.styling.Size.rem1
import dev.syncended.kube.website.web.components.Colors.colorBackground
import dev.syncended.kube.website.web.components.Colors.colorPageBackground
import dev.syncended.kube.website.web.components.Sizes.sizeMaxPage
import dev.syncended.kube.website.web.components.Sizes.spaceSizeDefault
import dev.syncended.kube.website.web.components.Sizes.spaceSizeSmall
import dev.syncended.kube.website.web.widget.toolbar

fun webpage(content: Column.() -> Unit): String = render {
  box(
    horizontalAlignment = Alignment.Horizontal.Center,
    modifier = Modifier.fillMaxSize()
      .backgroundColor(colorPageBackground)
  ) {
    column(
      modifier = Modifier.fillMaxWidth()
        .marginHorizontal(spaceSizeSmall)
        .maxWidth(sizeMaxPage)
    ) {

      toolbar()
      space(modifier = Modifier.height(spaceSizeSmall))
      content.invoke(this)
    }
  }
}

fun Layout.cardComponent(
  modifier: Modifier = Modifier,
  verticalAlignment: Alignment.Vertical? = null,
  horizontalAlignment: Alignment.Horizontal? = null,
  body: Card.() -> Unit
) = card(
  modifier = modifier.backgroundColor(colorBackground)
    .padding(spaceSizeDefault)
) {
  body()
}

fun Layout.codeBlock(body: Column.() -> Unit) {
  column(
    modifier = Modifier.fillMaxWidth()
      .backgroundColor(Colors.colorCodeBlockBackground)
      .paddingVertical(rem05)
      .paddingHorizontal(rem1)
      .borderRadius(rem1, rem1, rem1, rem1),
    body = body
  ) // TODO: Code block, allow copy
}