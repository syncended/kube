package dev.syncended.kube.website.ui.docs

enum class DocsPath {
  WELCOME,
  HTMX,
}

fun String.toDocsPath(): DocsPath {
  return DocsPath.entries.find { this.uppercase() == it.name }
    ?: DocsPath.WELCOME
}