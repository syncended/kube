package dev.syncended.kube.website.ui.page

import dev.syncended.kube.components.Column
import dev.syncended.kube.components.horizontalAlignment
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxSize
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.column
import dev.syncended.kube.website.ui.styling.Colors.colorPageBackground
import dev.syncended.kube.website.ui.styling.Sizes.sizeMaxPage
import dev.syncended.kube.website.ui.toolbar.toolbar

fun webpage(content: Column.() -> Unit): String = box {
  modifier.fillMaxSize()
    .backgorundColor(colorPageBackground)
    .horizontalAlignment(Alignment.Horizontal.Center)

  column {
    modifier.fillMaxWidth()
      .maxWidth(sizeMaxPage)

    toolbar()
    content.invoke(this)
  }
}