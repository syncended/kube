package dev.syncended.kube.website.ui.main

import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.column
import dev.syncended.kube.website.ui.styling.Sizes.sizeMaxPage
import dev.syncended.kube.website.ui.toolbar.toolbar

fun mainPage() = box {
  modifier.horizontalAlignment = Alignment.Horizontal.Center
  column {
    modifier.fillMaxWidth()
      .maxWidth(sizeMaxPage)

    toolbar()
  }
}