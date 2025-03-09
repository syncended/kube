package dev.syncended.kube

import dev.syncended.kube.components.ui.TextInputType
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.form
import dev.syncended.kube.dsl.hiddenInput
import dev.syncended.kube.dsl.text
import dev.syncended.kube.dsl.textInput

fun Layout.renderUi() = column {
  text("Hello playground!")
  renderForm()
}

fun Layout.renderForm() = form {
  column {
    text("Hello forms!")
    hiddenInput(name = "test_key", value = "test_value")
    textInput(name = "test_v2", value = "default text value")
    textInput(name = "test_password", type = TextInputType.PASSWORD)
  }
}