package dev.syncended.kube.website.ui.toolbar

import dev.syncended.kube.components.align
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.backgorundColor
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.minHeight
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.styling.Colors.red
import dev.syncended.kube.website.ui.styling.Sizes.sizeToolbarHeight

fun Layout<*>.toolbar() = row {
  modifier.fillMaxWidth()
    .minHeight(sizeToolbarHeight)
    .align(Alignment.Vertical.Center)
    .backgorundColor(red)

  text("te")
}