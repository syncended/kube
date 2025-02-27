package dev.syncended.kube.website.web.components

import dev.syncended.kube.components.layout.Card
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.card
import dev.syncended.kube.website.web.styling.Colors.colorBackground
import dev.syncended.kube.website.web.styling.Sizes.spaceSizeDefault

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