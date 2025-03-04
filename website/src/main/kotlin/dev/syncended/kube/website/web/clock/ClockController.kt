package dev.syncended.kube.website.web.clock

import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.dsl.render
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ClockController {

  @GetMapping("/clock")
  fun getClock() = render(mode = RenderMode.VIEW_ONLY) { clock() }
}