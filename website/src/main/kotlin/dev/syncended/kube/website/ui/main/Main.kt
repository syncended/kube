package dev.syncended.kube.website.ui.main

import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.text
import dev.syncended.kube.styling.Colors.red
import dev.syncended.kube.website.ui.styling.Sizes.sizeMaxPage

fun mainPage() = box {
  modifier.horizontalAlignment = Alignment.Horizontal.Center
  column {
    modifier.maxWidth(sizeMaxPage)
      .backgorundColor(red)
    text("aboba")
  }
}