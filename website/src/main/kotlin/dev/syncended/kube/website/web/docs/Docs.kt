package dev.syncended.kube.website.web.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.LayoutSize
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginBottom
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.component.renderOn
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.dsl.textLink
import dev.syncended.kube.website.web.components.cardComponent
import dev.syncended.kube.website.web.page.webpage
import dev.syncended.kube.website.web.styling.Sizes.sizeNavBar
import dev.syncended.kube.website.web.styling.Sizes.spaceSizeSmall

fun docs(path: DocsPath) = webpage {
  docsLayout(path) {
    when (path) {
      DocsPath.WELCOME -> welcome()
      DocsPath.HTMX -> htmxDocs()
    }
  }
}

private fun Layout.docsLayout(
  path: DocsPath,
  content: Column.() -> Unit
) = row(modifier = Modifier.fillMaxWidth()) {

  cardComponent(
    modifier = Modifier.renderOn(LayoutSize.Desktop)
      .fillMaxWidth()
      .maxWidth(sizeNavBar)
      .marginRight(spaceSizeSmall)
  ) {
    column { menuElements(path) }
  }

  column(modifier = Modifier.fillMaxWidth()) {

    cardComponent(
      modifier = Modifier.fillMaxWidth()
        .marginBottom(spaceSizeSmall)
        .renderOn(LayoutSize.Mobile)
    ) {
      column { menuElements(path) }
    }

    cardComponent(modifier = Modifier.fillMaxWidth()) {
      column(modifier = Modifier.fillMaxWidth()) { content() }
    }
  }
}

private fun Column.menuElements(path: DocsPath) {
  menuElement(
    name = "Welcome",
    path = DocsPath.WELCOME,
    selectedPath = path
  )
  menuElement(
    name = "HTMX Integration",
    path = DocsPath.HTMX,
    selectedPath = path
  )
}

private fun Column.menuElement(name: String, path: DocsPath, selectedPath: DocsPath) = row {
  if (path == selectedPath) text(">", modifier = Modifier.marginRight(spaceSizeSmall))
  textLink(text = name, href = "/docs/${path.name.lowercase()}")
}

