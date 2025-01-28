package dev.syncended.kube.website.web.page

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.fillMaxSize
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.height
import dev.syncended.kube.core.component.marginHorizontal
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.space
import dev.syncended.kube.website.web.components.toolbar
import dev.syncended.kube.website.web.styling.Colors.colorPageBackground
import dev.syncended.kube.website.web.styling.Sizes.sizeMaxPage
import dev.syncended.kube.website.web.styling.Sizes.spaceSizeSmall

fun webpage(content: Column.() -> Unit): String = box(
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