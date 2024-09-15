package dev.syncended.kube.website.ui.docs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DocsController {

  @GetMapping("/docs")
  fun getDocs(): String = docs(DocsPath.WELCOME)

  @GetMapping("/docs/{path}")
  fun getDocs(@PathVariable("path") path: String): String = docs(path.toDocsPath())
}