package dev.syncended.kube.dsl

import dev.syncended.kube.components.layout.FormEncoding
import dev.syncended.kube.components.layout.HttpMethod
import dev.syncended.kube.components.ui.ButtonInput
import dev.syncended.kube.components.ui.ButtonType
import dev.syncended.kube.components.ui.DateTimeInput
import dev.syncended.kube.components.ui.DateTimeType
import dev.syncended.kube.components.ui.HiddenInput
import dev.syncended.kube.components.ui.TextInput
import dev.syncended.kube.components.ui.TextInputType
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

fun Layout.hiddenInput(
  name: String,
  value: String,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
) = widget(
  instance = HiddenInput(
    name = name,
    value = value,
    formEncoding = formEncoding,
    formMethod = formMethod
  )
)

fun Layout.textInput(
  modifier: Modifier = Modifier,
  type: TextInputType = TextInputType.TEXT,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
  name: String? = null,
  value: String = "",
) = widget(
  instance = TextInput(
    name = name,
    value = value,
    modifier = modifier,
    type = type,
    formEncoding = formEncoding,
    formMethod = formMethod
  )
)

fun Layout.buttonInput(
  modifier: Modifier = Modifier,
  type: ButtonType = ButtonType.BUTTON,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
  name: String? = null,
  text: String = "",
) = widget(
  instance = ButtonInput(
    name = name,
    text = text,
    modifier = modifier,
    type = type,
    formEncoding = formEncoding,
    formMethod = formMethod
  )
)


fun Layout.dateTimeInput(
  modifier: Modifier = Modifier,
  type: DateTimeType = DateTimeType.DATE_TIME,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
  name: String? = null,
  value: String = "",
) = widget(
  instance = DateTimeInput(
    name = name,
    value = value,
    modifier = modifier,
    type = type,
    formEncoding = formEncoding,
    formMethod = formMethod
  )
)