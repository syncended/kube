package dev.syncended.kube.website.web.main

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

  @GetMapping("/")
  suspend fun getMain() = mainPage()
}