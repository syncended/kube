package dev.syncended.kube.website.ui.components

import dev.syncended.kube.components.Card
import dev.syncended.kube.core.component.AnyLayout
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.dsl.card
import dev.syncended.kube.website.ui.styling.Colors.colorBackground
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeDefault

fun AnyLayout.cardComponent(body: Card.() -> Unit) = card {
  modifier.backgorundColor(colorBackground)
    .padding(spaceSizeDefault)

  body()
}