package dev.syncended.kube.components.ui

import dev.syncended.kube.components.layout.FormEncoding
import dev.syncended.kube.components.layout.HttpMethod
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.InputType

abstract class AbstractInput(
  modifier: Modifier,
  private val inputType: InputType?,
  private val formEncoding: FormEncoding?,
  private val formMethod: HttpMethod?,
  private val name: String?
) : Layout(modifier) {

  protected open val value: String? = null

  override fun render() = input(
    type = inputType,
    formEncType = formEncoding?.toInputFormEncType(),
    formMethod = formMethod?.toInputFormMethod(),
    name = name
  ) {
    this@AbstractInput.value?.let { value = it }
  }
}

class HiddenInput(
  name: String,
  override val value: String,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
) : AbstractInput(
  modifier = Modifier,
  inputType = InputType.hidden,
  formEncoding = formEncoding,
  formMethod = formMethod,
  name = name,
)

class TextInput(
  modifier: Modifier = Modifier,
  type: TextInputType = TextInputType.TEXT,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
  name: String? = null,
  override val value: String = ""
) : AbstractInput(
  modifier = modifier,
  name = name,
  formEncoding = formEncoding,
  formMethod = formMethod,
  inputType = type.toInputType()
)

class ButtonInput(
  modifier: Modifier = Modifier,
  type: ButtonType = ButtonType.BUTTON,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
  name: String? = null,
  text: String = ""
) : AbstractInput(
  modifier = modifier,
  name = name,
  formEncoding = formEncoding,
  formMethod = formMethod,
  inputType = type.toInputType()
) {
  override val value: String = text
}

class DateTimeInput(
  modifier: Modifier = Modifier,
  type: DateTimeType = DateTimeType.DATE_TIME,
  formEncoding: FormEncoding? = null,
  formMethod: HttpMethod? = null,
  name: String? = null,
  override val value: String = ""
) : AbstractInput(
  modifier = modifier,
  name = name,
  formEncoding = formEncoding,
  formMethod = formMethod,
  inputType = type.toInputType()
)

enum class TextInputType {
  EMAIL,
  NUMBER,
  PASSWORD,
  SEARCH,
  TEL,
  TEXT,
  URL,
}

enum class ButtonType {
  BUTTON,
  RESET,
  SUBMIT
}

enum class DateTimeType {
  DATE,
  DATE_TIME,
  DATE_TIME_LOCAL,
  MONTH,
  TIME,
  WEEK
}

private fun TextInputType.toInputType(): InputType = when (this) {
  TextInputType.EMAIL -> InputType.email
  TextInputType.NUMBER -> InputType.number
  TextInputType.PASSWORD -> InputType.password
  TextInputType.SEARCH -> InputType.search
  TextInputType.TEL -> InputType.tel
  TextInputType.TEXT -> InputType.text
  TextInputType.URL -> InputType.url
}

private fun ButtonType.toInputType(): InputType = when (this) {
  ButtonType.BUTTON -> InputType.button
  ButtonType.RESET -> InputType.reset
  ButtonType.SUBMIT -> InputType.submit
}

private fun DateTimeType.toInputType(): InputType = when (this) {
  DateTimeType.DATE -> InputType.date
  DateTimeType.DATE_TIME -> InputType.dateTime
  DateTimeType.DATE_TIME_LOCAL -> InputType.dateTimeLocal
  DateTimeType.MONTH -> InputType.month
  DateTimeType.TIME -> InputType.time
  DateTimeType.WEEK -> InputType.week
}

/*
TODO
    checkBox("checkbox"),
    color("color"),
    file("file"),
    image("image"),
    radio("radio"),
    range("range"),
 */

private fun FormEncoding.toInputFormEncType() = when (this) {
  FormEncoding.TEXT_PLAIN -> InputFormEncType.textPlain
  FormEncoding.MULTIPART_FORM_DATA -> InputFormEncType.multipartFormData
  FormEncoding.APPLICATION_X_WWW_FORM_URL_ENCODED -> InputFormEncType.applicationXWwwFormUrlEncoded
}

private fun HttpMethod.toInputFormMethod(): InputFormMethod = when (this) {
  HttpMethod.GET -> InputFormMethod.get
  HttpMethod.POST -> InputFormMethod.post
  HttpMethod.PUT -> InputFormMethod.put
  HttpMethod.PATCH -> InputFormMethod.patch
  HttpMethod.DELETE -> InputFormMethod.delete
}

