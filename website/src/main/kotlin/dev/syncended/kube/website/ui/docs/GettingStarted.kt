package dev.syncended.kube.website.ui.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.height
import dev.syncended.kube.core.component.width
import dev.syncended.kube.dsl.space
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.components.title
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeDefault
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeSmall

fun Column.gettingStarted() {
  title("Getting started")

  space { modifier.height(spaceSizeSmall) }
  text("KUBE - dsl library, for build simple webpages")
  text("TODO(\"Add some description here\");")
  text("TODO(\"Add some samples here\");")
  text("TODO(\"Add maven library\");")
}