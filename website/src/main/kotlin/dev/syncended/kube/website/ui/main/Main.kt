package dev.syncended.kube.website.ui.main

import dev.syncended.kube.components.fontSize
import dev.syncended.kube.components.textSize
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.padding
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.dsl.card
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.components.title
import dev.syncended.kube.website.ui.page.webpage
import dev.syncended.kube.website.ui.styling.Colors
import dev.syncended.kube.website.ui.styling.Sizes
import dev.syncended.kube.website.ui.styling.Sizes.fontSizeHeader

fun mainPage() = webpage {
  card {
    modifier.fillMaxWidth()
      .padding(Sizes.spaceSizeDefault)
      .backgorundColor(Colors.colorBackground)

    title("What is KUBE?")
  }
}
