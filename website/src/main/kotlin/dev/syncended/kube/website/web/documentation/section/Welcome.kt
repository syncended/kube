package dev.syncended.kube.website.web.documentation.section

import dev.syncended.kube.components.layout.Column
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.core.component.marginVertical
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.dsl.text
import dev.syncended.kube.styling.Size.rem1
import dev.syncended.kube.website.web.components.Sizes.spaceSizeDefault
import dev.syncended.kube.website.web.components.Sizes.spaceSizeSmall
import dev.syncended.kube.website.web.components.codeBlock
import dev.syncended.kube.website.web.components.title

fun Column.welcome() {
  title("What is KUBE?")
  text(
    text = "KUBE - Kotlin Ui Builder.",
    modifier = Modifier.marginVertical(spaceSizeSmall)
  )
  text("KUBE is an open-source library, that simplifies your routine of creating internal web interfaces (like an admin panel, or smth else).")


  title("Integration", modifier = Modifier.marginTop(spaceSizeDefault))

  text(
    "KUBE is available at maven central repository",
    modifier = Modifier.marginTop(spaceSizeSmall)
  ) //TODO: Add hyperlink
  text("Maven", fontSize = FontSize.Medium, modifier = Modifier.marginTop(spaceSizeSmall))
  codeBlock {
    text("<dependency>")
    text("<groupId>dev.syncended</groupId>", modifier = Modifier.marginLeft(rem1))
    text("<artifactId>kube-core</artifactId>", modifier = Modifier.marginLeft(rem1))
    text("<version>x.y.z</version>", modifier = Modifier.marginLeft(rem1))
    text("</dependency>")
  }

  text("Gradle", fontSize = FontSize.Medium, modifier = Modifier.marginTop(spaceSizeDefault))
  codeBlock {
    text("implementation(\"dev.syncended:kube-core:x.y.z\")")
  }
}