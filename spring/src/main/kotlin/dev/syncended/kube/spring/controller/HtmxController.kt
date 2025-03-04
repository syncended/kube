package dev.syncended.kube.spring.controller

import dev.syncended.kube.htmx.utils.htmxSource
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
  value = ["kube.htmx"],
  havingValue = "true",
  matchIfMissing = false
)
@RequestMapping("/\${kube.resources.prefix:static}")
class HtmxController {

  @GetMapping("/js/htmx.min.js")
  fun getHtmx(): ResponseEntity<String> {
    val headers = HttpHeaders()
    headers.contentType = MediaType.valueOf("text/javascript")
    return ResponseEntity(
      htmxSource,
      headers,
      HttpStatus.OK,
    )
  }
}