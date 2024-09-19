package dev.syncended.kube.website.ui.main

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.marginVertical
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.components.title
import dev.syncended.kube.website.ui.page.webpage
import dev.syncended.kube.website.ui.styling.Colors
import dev.syncended.kube.website.ui.styling.Sizes
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeSmall

fun mainPage() = webpage {
  card(
    modifier = Modifier.fillMaxWidth()
      .padding(Sizes.spaceSizeDefault)
      .backgroundColor(Colors.colorBackground)
  ) {

    column {
      title("What is KUBE?")
      text(
        text = "KUBE - Kotlin Ui Builder.",
        modifier = Modifier.marginVertical(spaceSizeSmall)
      )
      text("KUBE is an open-source library, that simplifies your routine of creating internal web interfaces (like an admin panel, or smth else).")

    }
  }
}
