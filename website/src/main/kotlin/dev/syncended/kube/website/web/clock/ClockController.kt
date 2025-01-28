package dev.syncended.kube.website.web.clock

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ClockController {

  @GetMapping("/clock")
  fun getClock() = clockPage()
}