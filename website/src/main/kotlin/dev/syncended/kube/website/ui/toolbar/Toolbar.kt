package dev.syncended.kube.website.ui.toolbar

import dev.syncended.kube.components.align
import dev.syncended.kube.components.horizontalAlignment
import dev.syncended.kube.components.verticalAlignment
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxHeight
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.minHeight
import dev.syncended.kube.core.component.paddingHorizontal
import dev.syncended.kube.core.component.size
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.svgImage
import dev.syncended.kube.website.ui.components.title
import dev.syncended.kube.website.ui.styling.Colors.colorBackground
import dev.syncended.kube.website.ui.styling.Images.cubeLogo
import dev.syncended.kube.website.ui.styling.Sizes.sizeIconDefault
import dev.syncended.kube.website.ui.styling.Sizes.sizeToolbarHeight
import dev.syncended.kube.website.ui.styling.Sizes.spaceDefault

fun Layout<*>.toolbar() = card {
  modifier.fillMaxWidth()
    .paddingHorizontal(spaceDefault)
    .minHeight(sizeToolbarHeight)
    .backgorundColor(colorBackground)

  row {
    modifier.fillMaxHeight().align(Alignment.Vertical.Center)

    svgImage(rawImage = cubeLogo) { modifier.size(sizeIconDefault) }
    title("KUBE") { modifier.marginLeft(spaceDefault) }
  }
}