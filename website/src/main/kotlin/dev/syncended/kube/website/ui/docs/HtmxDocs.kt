package dev.syncended.kube.website.ui.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.htmx.model.HxSwap
import dev.syncended.kube.htmx.modifier.hxGet
import dev.syncended.kube.htmx.modifier.hxSwap
import dev.syncended.kube.htmx.modifier.hxTrigger
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeDefault


fun Column.htmxDocs() {
  text("HTMX - open source library, to create lightweight dynamic websites")
  text(
    text = "In case of KUBE - it allow to extend functions of library, " +
      "to provide more ways, how to use the library",
    modifier = Modifier.marginTop(spaceSizeDefault)
  )

  row(
    modifier = Modifier.fillMaxWidth()
      .marginTop(spaceSizeDefault)
  ) {
    text("Sample widget, using htmx:")
    box(
      modifier = Modifier.marginLeft(spaceSizeDefault)
        .hxGet("/clock")
        .hxSwap(HxSwap.InnerHTML)
        .hxTrigger("every 1s")
    )
  }
}