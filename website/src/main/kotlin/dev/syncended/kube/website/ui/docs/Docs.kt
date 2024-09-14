package dev.syncended.kube.website.ui.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.AnyLayout
import dev.syncended.kube.core.component.LayoutSize
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.component.renderOn
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.components.cardComponent
import dev.syncended.kube.website.ui.page.webpage
import dev.syncended.kube.website.ui.styling.Sizes.sizeNavBar
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeSmall

fun docs() = webpage {
  docsLayout {
    gettingStarted()
  }
}

private fun AnyLayout.docsLayout(content: Column.() -> Unit) = row {
  modifier.fillMaxWidth()

  cardComponent {
    modifier.renderOn(LayoutSize.Desktop)
      .fillMaxWidth()
      .maxWidth(sizeNavBar)
      .marginRight(spaceSizeSmall)

    text("Getting started")
  }

  cardComponent {
    modifier.fillMaxWidth()

    column {
      modifier.fillMaxWidth()
      content()
    }
  }
}