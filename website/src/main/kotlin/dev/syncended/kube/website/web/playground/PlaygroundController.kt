package dev.syncended.kube.website.web.playground

import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.web.page.webpage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PlaygroundController {

  @GetMapping("/playground")
  fun getPlayground() = webpage {
    box {
      text("boba")
      text("aliboba")
    }
  }
}