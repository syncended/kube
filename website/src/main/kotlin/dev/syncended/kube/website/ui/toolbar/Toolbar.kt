package dev.syncended.kube.website.ui.toolbar

import dev.syncended.kube.components.align
import dev.syncended.kube.components.fontSize
import dev.syncended.kube.components.textSize
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.minHeight
import dev.syncended.kube.core.component.paddingHorizontal
import dev.syncended.kube.core.component.size
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.svgImage
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.styling.Colors.colorBackground
import dev.syncended.kube.website.ui.styling.Images.cubeLogo
import dev.syncended.kube.website.ui.styling.Sizes.sizeFontHeader
import dev.syncended.kube.website.ui.styling.Sizes.sizeIconDefault
import dev.syncended.kube.website.ui.styling.Sizes.sizeToolbarHeight
import dev.syncended.kube.website.ui.styling.Sizes.spaceDefault

fun Layout<*>.toolbar() = row {
  modifier.fillMaxWidth()
    .paddingHorizontal(spaceDefault)
    .minHeight(sizeToolbarHeight)
    .align(Alignment.Vertical.Center)
    .backgorundColor(colorBackground)

  svgImage(rawImage = cubeLogo) { modifier.size(sizeIconDefault) }
  text("KUBE") {
    modifier.textSize(sizeFontHeader)
      .fontSize(fontSize = FontSize.Bold)
      .marginLeft(spaceDefault)
  }
}