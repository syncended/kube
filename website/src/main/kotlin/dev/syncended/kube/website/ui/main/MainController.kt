package dev.syncended.kube.website.ui.main

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

  @GetMapping("/")
  suspend fun getMain() = mainPage()
}