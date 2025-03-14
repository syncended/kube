package dev.syncended.kube.website.web.documentation.section

import dev.syncended.kube.components.layout.Column
import dev.syncended.kube.components.ui.ButtonType
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.borderBottomLeftRadius
import dev.syncended.kube.core.component.borderBottomRightRadius
import dev.syncended.kube.core.component.borderTopLeftRadius
import dev.syncended.kube.core.component.borderTopRightRadius
import dev.syncended.kube.core.component.fillMaxWidth
import dev.syncended.kube.core.component.height
import dev.syncended.kube.core.component.marginBottom
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.core.component.marginVertical
import dev.syncended.kube.core.component.size
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.model.px
import dev.syncended.kube.core.model.rm
import dev.syncended.kube.core.model.toClassSelector
import dev.syncended.kube.dsl.buttonInput
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.form
import dev.syncended.kube.dsl.hiddenInput
import dev.syncended.kube.dsl.render
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.space
import dev.syncended.kube.dsl.text
import dev.syncended.kube.htmx.modifier.hxGet
import dev.syncended.kube.htmx.modifier.hxTarget
import dev.syncended.kube.htmx.modifier.hxTrigger
import dev.syncended.kube.styling.Size.rem1
import dev.syncended.kube.website.web.components.Sizes.spaceSizeDefault
import dev.syncended.kube.website.web.components.Sizes.spaceSizeSmall
import dev.syncended.kube.website.web.components.codeBlock
import dev.syncended.kube.website.web.components.title
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

private val dependencies = "dependencies".toClassSelector()

@RestController
class WelcomeController {
  @GetMapping("/welcome/dependency")
  fun getDependency(@RequestParam("gradle", required = true) gradle: Boolean) = render(mode = RenderMode.VIEW_ONLY) {
    dependency(gradle)
  }
}

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

  dependency(gradle = false)
}

private fun Layout.dependency(gradle: Boolean) = column(
  modifier = Modifier.fillMaxWidth()
    .withClass(dependencies)
    .marginTop(spaceSizeSmall)
) {
  row(modifier = Modifier.marginBottom(spaceSizeSmall)) {
    form(
      modifier = Modifier.hxGet("/welcome/dependency")
        .hxTarget(dependencies)
    ) {
      hiddenInput(name = "gradle", value = "false")
      buttonInput(
        text = "Maven",
        modifier = Modifier
          .borderTopRightRadius(0.rm)
          .borderBottomRightRadius(0.rm),
        type = ButtonType.SUBMIT
      )
    }
    form(
      modifier = Modifier.hxGet("/welcome/dependency")
        .hxTarget(dependencies)
    ) {
      hiddenInput(name = "gradle", value = "true")
      buttonInput(
        text = "Gradle",
        modifier = Modifier
          .marginLeft((-2).px)
          .borderTopLeftRadius(0.rm)
          .borderBottomLeftRadius(0.rm),
        type = ButtonType.SUBMIT
      )
    }
  }
  if (gradle) {
    codeBlock {
      text("implementation(\"dev.syncended:kube-core:x.y.z\")")
      text("implementation(\"dev.syncended:kube-htmx:x.y.z\")")
      text("implementation(\"dev.syncended:kube-ktor:x.y.z\")")
      text("implementation(\"dev.syncended:kube-spring:x.y.z\")")
    }
  } else {
    codeBlock {
      mavenDependency("kube-core")
      space(Modifier.height(spaceSizeSmall))
      mavenDependency("kube-htmx")
      space(Modifier.height(spaceSizeSmall))
      mavenDependency("kube-ktor")
      space(Modifier.height(spaceSizeSmall))
      mavenDependency("kube-spring")
    }
  }
}

private fun Layout.mavenDependency(artifact: String) {
  text("<dependency>")
  text("<groupId>dev.syncended</groupId>", modifier = Modifier.marginLeft(rem1))
  text("<artifactId>$artifact</artifactId>", modifier = Modifier.marginLeft(rem1))
  text("<version>x.y.z</version>", modifier = Modifier.marginLeft(rem1))
  text("</dependency>")
}
