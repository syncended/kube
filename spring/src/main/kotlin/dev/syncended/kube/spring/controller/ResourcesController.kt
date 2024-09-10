package dev.syncended.kube.spring.controller

import dev.syncended.kube.core.model.getBytes
import dev.syncended.kube.core.model.name
import dev.syncended.kube.core.styling.KubeStyling
import dev.syncended.kube.spring.utils.contentType
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.web.WebProperties.Resources
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
  private val mainCss by lazy { KubeStyling.buildStyle() }

  @GetMapping("/css/main.css")
  fun fonts(): ResponseEntity<String> {
    val headers = HttpHeaders()
    headers.contentType = MediaType.valueOf("text/css")
    return ResponseEntity(
      mainCss,
      headers,
      HttpStatus.OK,
    )
  }

  @GetMapping("/font/{path}")
  fun getFont(@PathVariable("path") path: String): ResponseEntity<ByteArray> {
    val font = KubeStyling.getFonts().flatMap { it.resources }
      .find { it.name == path }
      ?: return ResponseEntity(HttpStatus.NOT_FOUND)

    val headers = HttpHeaders()
    headers.contentType = font.contentType
    val resource = font.getBytes()
    return ResponseEntity(
      resource,
      headers,
      HttpStatus.OK
    )
  }
}