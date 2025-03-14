package dev.syncended.kube.website.web.widget.not_found

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.web.components.cardComponent
import dev.syncended.kube.website.web.components.webpage
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NotFoundController {

  @GetMapping("/**")
  fun redirect(serverHttpResponse: ServerHttpResponse) {
    serverHttpResponse.apply {
      statusCode = HttpStatus.TEMPORARY_REDIRECT
      headers.set("Location", "/not-found")
    }
  }

  @GetMapping("/not-found")
  fun notFound(): String = webpage {
    cardComponent(modifier = Modifier.fillMaxWidth()) {
      text(text = "Nothing was found :(")
    }
  }
}
