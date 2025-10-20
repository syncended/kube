package dev.syncended.kube.website.web.main

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.core.component.weight
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.column
import dev.syncended.kube.website.web.components.Colors
import dev.syncended.kube.website.web.components.Sizes
import dev.syncended.kube.website.web.components.webpage

// @RestController
// class MainController {
//
//   @GetMapping("/")
//   suspend fun getMain() = mainPage()
// }

fun mainPage() = webpage {
  card(
    modifier = Modifier.weight(1)
      .padding(Sizes.spaceSizeDefault)
      .backgroundColor(Colors.colorBackground)
  ) {

    column {


    }
  }
}
