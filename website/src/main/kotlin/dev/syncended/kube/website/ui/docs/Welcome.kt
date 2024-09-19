package dev.syncended.kube.website.ui.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.components.title
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeSmall

fun Column.welcome() {
  title("KUBE Documentation")

  text(
    text = "KUBE - dsl library, for build simple webpages",
    modifier = Modifier.marginTop(spaceSizeSmall)
  )
  text("TODO(\"Add some description here\");")
  text("TODO(\"Add some samples here\");")
  text("TODO(\"Add maven library\");")
}