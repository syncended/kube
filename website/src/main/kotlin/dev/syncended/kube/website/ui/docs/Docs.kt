package dev.syncended.kube.website.ui.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.AnyLayout
import dev.syncended.kube.core.component.LayoutSize
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginBottom
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.component.renderOn
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.dsl.textLink
import dev.syncended.kube.website.ui.components.cardComponent
import dev.syncended.kube.website.ui.page.webpage
import dev.syncended.kube.website.ui.styling.Sizes.sizeNavBar
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeSmall

fun docs(path: DocsPath) = webpage {
  docsLayout(path) {
    when (path) {
      DocsPath.WELCOME -> welcome()
      DocsPath.TEST -> text("todo")
    }
  }
}

private fun AnyLayout.docsLayout(path: DocsPath, content: Column.() -> Unit) = row {
  modifier.fillMaxWidth()

  cardComponent {
    modifier.renderOn(LayoutSize.Desktop)
      .fillMaxWidth()
      .maxWidth(sizeNavBar)
      .marginRight(spaceSizeSmall)

    column { menuElements(path) }
  }

  column {
    modifier.fillMaxWidth()

    cardComponent {
      modifier.fillMaxWidth()
        .marginBottom(spaceSizeSmall)
        .renderOn(LayoutSize.Mobile)
      column { menuElements(path) }
    }

    cardComponent {
      modifier.fillMaxWidth()
      column { content() }
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
    name = "Test page",
    path = DocsPath.TEST,
    selectedPath = path
  )
}

private fun Column.menuElement(name: String, path: DocsPath, selectedPath: DocsPath) = row {
  if (path == selectedPath) text(">") { modifier.marginRight(spaceSizeSmall) }
  textLink(text = name, href = "/docs/${path.name.lowercase()}")
}

