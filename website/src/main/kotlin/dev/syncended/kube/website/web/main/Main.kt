package dev.syncended.kube.website.web.main

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginVertical
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.web.components.title
import dev.syncended.kube.website.web.components.webpage
import dev.syncended.kube.website.web.components.Colors
import dev.syncended.kube.website.web.components.Sizes
import dev.syncended.kube.website.web.components.Sizes.spaceSizeSmall
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// @RestController
// class MainController {
//
//   @GetMapping("/")
//   suspend fun getMain() = mainPage()
// }

fun mainPage() = webpage {
  card(
    modifier = Modifier.fillMaxWidth()
      .padding(Sizes.spaceSizeDefault)
      .backgroundColor(Colors.colorBackground)
  ) {

    column {


    }
  }
}
