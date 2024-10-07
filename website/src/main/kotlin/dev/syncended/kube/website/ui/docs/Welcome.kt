package dev.syncended.kube.website.ui.docs

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.dsl.markdown
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.components.title
import dev.syncended.kube.website.ui.styling.Sizes.spaceSizeSmall

fun Column.welcome() {
  title("KUBE Documentation")

  text(
    text = "KUBE - dsl library, for build simple webpages",
    modifier = Modifier.marginTop(spaceSizeSmall)
  )

  text("KUBE is available on maven central repository")
  markdown {
    """
      *bold text*
      
      **not bold text**
      
      ~~sc~~
      
      ~~~
      dependencies {
        implementation("dev.syncended:kube-core:0.1.0")
        implementation("dev.syncended:kube-htmx:0.1.0")
        implementation("dev.syncended:kube-spring-core:0.1.0")
        implementation("dev.syncended:kube-spring-htmx:0.1.0")
      }
      ~~~
    """.trimIndent()
  }
  text("TODO(\"Add some description here\");")
  text("TODO(\"Add some samples here\");")
  text("TODO(\"Add maven library\");")
}