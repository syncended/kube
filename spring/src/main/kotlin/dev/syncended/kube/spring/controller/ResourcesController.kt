package dev.syncended.kube.spring.controller

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ConditionalOnProperty(
  value = ["kube.resources.mode"],
  havingValue = "LINK",
  matchIfMissing = true
)
@RequestMapping("/\${kube.resources.prefix:static}")
class ResourcesController {

  @GetMapping("/main.css")
  fun test(): String {
    return """
    <html>
    <body>
    <p>Hello config</p>
    </body>
    </html>
  """.trimIndent()
  }
}