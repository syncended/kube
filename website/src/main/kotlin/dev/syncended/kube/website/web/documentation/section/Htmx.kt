package dev.syncended.kube.website.web.documentation.section

import dev.syncended.kube.components.layout.Column
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.web.widget.clock.clock
import dev.syncended.kube.website.web.components.Sizes.spaceSizeDefault

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
    text("Sample widget, using htmx:", Modifier.marginRight(spaceSizeDefault))
    clock()
  }
}