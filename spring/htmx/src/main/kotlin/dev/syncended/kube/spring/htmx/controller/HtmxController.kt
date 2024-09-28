package dev.syncended.kube.spring.htmx.controller

import dev.syncended.kube.htmx.KubeHtmxPlugins
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
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
class HtmxController {

  @GetMapping("/js/htmx.min.js")
  fun getHtmx(): ResponseEntity<String> {
    val headers = HttpHeaders()
    headers.contentType = MediaType.valueOf("text/javascript")
    return ResponseEntity(
      KubeHtmxPlugins.htmxSource,
      headers,
      HttpStatus.OK,
    )
  }
}