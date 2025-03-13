package dev.syncended.kube.website.web.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.minHeight
import dev.syncended.kube.core.component.paddingVertical
import dev.syncended.kube.core.component.size
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.link
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.space
import dev.syncended.kube.styling.Size.rem0
import dev.syncended.kube.website.web.components.Images.cubeLogo
import dev.syncended.kube.website.web.components.Sizes.sizeIconDefault
import dev.syncended.kube.website.web.components.Sizes.sizeToolbarHeight
import dev.syncended.kube.website.web.components.Sizes.spaceSizeDefault

fun Layout.toolbar() = cardComponent(
  verticalAlignment = Alignment.Vertical.Center,
  modifier = Modifier.fillMaxWidth()
    .minHeight(sizeToolbarHeight)
    .paddingVertical(rem0)
) {

  row(
    alignment = Alignment.Vertical.Center,
    modifier = Modifier.fillMaxWidth()
  ) {
    logo()
    space(Modifier.fillMaxWidth())
    menu()
  }
}

private fun Layout.logo() = link(href = "/") {
  row(alignment = Alignment.Vertical.Center) {
    svgImage(
      image = cubeLogo,
      modifier = Modifier.size(sizeIconDefault)
    )
    heading(
      text = "KUBE",
      modifier = Modifier.marginLeft(spaceSizeDefault)
    )
  }
}

private fun Layout.menu() {
  link(
    text = "Docs",
    href = "/docs",
    modifier = Modifier.marginRight(spaceSizeDefault)
  )
  link(
    text = "GitHub",
    href = "https://github.com/syncended/kube"
  )
}