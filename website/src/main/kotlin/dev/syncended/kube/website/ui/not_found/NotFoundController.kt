package dev.syncended.kube.website.ui.not_found

import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.page.webpage
import dev.syncended.kube.website.ui.styling.Colors.colorBackground
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeDefault
import org.springframework.http.HttpStatusCode
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NotFoundController {

  @GetMapping("/**")
  fun redirect(serverHttpResponse: ServerHttpResponse){
    serverHttpResponse.apply {
      statusCode =  HttpStatusCode.valueOf(301)
      headers.set("Location", "/not-found")
      headers.set("Connection", "close")
    }
  }

  @GetMapping("/not-found")
  fun notFound(): String = webpage {
    card {
      modifier.fillMaxWidth()
        .padding(spaceSizeDefault)
        .backgorundColor(colorBackground)

      text(text = "Nothing was found :(")
    }
  }
}