package dev.syncended.kube.website.ui.components

import dev.syncended.kube.components.align
import dev.syncended.kube.components.href
import dev.syncended.kube.components.verticalAlignment
import dev.syncended.kube.core.component.AnyLayout
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.minHeight
import dev.syncended.kube.core.component.paddingHorizontal
import dev.syncended.kube.core.component.size
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.link
import dev.syncended.kube.dsl.textLink
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.space
import dev.syncended.kube.dsl.svgImage
import dev.syncended.kube.website.ui.styling.Colors.colorBackground
import dev.syncended.kube.website.ui.styling.Images.cubeLogo
import dev.syncended.kube.website.ui.styling.Sizes.sizeIconDefault
import dev.syncended.kube.website.ui.styling.Sizes.sizeToolbarHeight
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeDefault

fun AnyLayout.toolbar() = card {
  modifier.fillMaxWidth()
    .minHeight(sizeToolbarHeight)
    .verticalAlignment(Alignment.Vertical.Center)
    .paddingHorizontal(spaceSizeDefault)
    .backgorundColor(colorBackground)

  row {
    modifier.fillMaxWidth()
      .align(Alignment.Vertical.Center)

    logo()
    space { modifier.fillMaxWidth() }
    textLink(text = "GitHub", href = "https://github.com/syncended/kube")
  }
}

private fun AnyLayout.logo() = link {
  modifier.href("/")

  row {
    modifier.align(Alignment.Vertical.Center)

    svgImage(rawImage = cubeLogo) { modifier.size(sizeIconDefault) }
    heading("KUBE") { modifier.marginLeft(spaceSizeDefault) }
  }
}