package dev.syncended.kube

import dev.syncended.kube.components.layout.HttpMethod
import dev.syncended.kube.components.ui.ButtonInput
import dev.syncended.kube.components.ui.ButtonType
import dev.syncended.kube.components.ui.TextInputType
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.fillMaxSize
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.toColor
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.buttonInput
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.form
import dev.syncended.kube.dsl.hiddenInput
import dev.syncended.kube.dsl.text
import dev.syncended.kube.dsl.textInput
import dev.syncended.kube.styling.Colors

private val gray = "#666".toColor()

fun Layout.renderUi() = box(
  modifier = Modifier.backgroundColor(gray).fillMaxSize(),
  verticalAlignment = Alignment.Vertical.Center,
  horizontalAlignment = Alignment.Horizontal.Center
) {
  column {
    text("Hello playground!")
    renderForm()
  }
}

fun Layout.renderForm() = form(action = "/", method = HttpMethod.GET) {
  column {
    text("Hello forms!")
    hiddenInput(name = "test_key", value = "test_value")
    textInput(name = "test_v2", value = "default text value")
    textInput(name = "test_password", type = TextInputType.PASSWORD)
    buttonInput(text = "Reset", type = ButtonType.RESET)
    buttonInput(text = "submit", type = ButtonType.SUBMIT)
  }
}