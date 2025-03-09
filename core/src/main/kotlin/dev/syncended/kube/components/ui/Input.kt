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
  private val inputType: InputType? = null,
  private val formEncoding: FormEncoding? =  null,
  private val formMethod: HttpMethod? = null,
  private val name: String? = null

): Layout(modifier) {

  override fun render() = input(
    type = inputType,
    formEncType = formEncoding?.toInputFormEncType(),
    formMethod = formMethod?.toInputFormMethod(),
    name = name
  )
}

private fun FormEncoding.toInputFormEncType() = when(this) {
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

