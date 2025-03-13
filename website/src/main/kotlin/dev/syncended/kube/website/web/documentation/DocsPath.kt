package dev.syncended.kube.website.web.documentation

enum class DocsPath {
  WELCOME,
  COMPONENTS,
  HTMX,
}

fun String.toDocsPath(): DocsPath {
  return DocsPath.entries.find { this.uppercase() == it.name }
    ?: DocsPath.WELCOME
}