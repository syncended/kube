package dev.syncended.kube.website.web.documentation

import dev.syncended.kube.components.layout.Column
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.LayoutSize
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginBottom
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.component.renderOn
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.link
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.web.components.Sizes.sizeNavBar
import dev.syncended.kube.website.web.components.Sizes.spaceSizeSmall
import dev.syncended.kube.website.web.components.cardComponent
import dev.syncended.kube.website.web.components.webpage
import dev.syncended.kube.website.web.documentation.section.components
import dev.syncended.kube.website.web.documentation.section.htmxDocs
import dev.syncended.kube.website.web.documentation.section.welcome
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DocsController {

  @GetMapping("/")
  fun getDocs(): String = docs(DocsPath.WELCOME)

  @GetMapping("/{path}")
  fun getDocs(@PathVariable("path") path: String): String = docs(path.toDocsPath())
}


fun docs(path: DocsPath) = webpage {
  docsLayout(path) {
    when (path) {
      DocsPath.WELCOME -> welcome()
      DocsPath.COMPONENTS -> components()
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
    name = "Components",
    path = DocsPath.COMPONENTS,
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
  link(text = name, href = "/${path.name.lowercase()}")
}

