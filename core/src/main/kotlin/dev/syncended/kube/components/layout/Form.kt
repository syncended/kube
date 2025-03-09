package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod as HtmlFormMethod

class Form(
    modifier: Modifier,
    private val action: String? = null,
    private val encoding: FormEncoding? = null,
    private val method: FormMethod? = null
) : Layout(modifier) {

    override fun render() = form(
        action = action,
        encType = encoding?.toFormEnc(),
        method = method?.toHtmlFormMethod()
    ) { renderChild(this) }
}

enum class FormEncoding {
    MULTIPART_FORM_DATA,
    APPLICATION_X_WWW_FORM_URL_ENCODED,
    TEXT_PLAIN,
}

enum class FormMethod {
    GET,
    POST,
}

private fun FormEncoding.toFormEnc(): FormEncType = when (this) {
    FormEncoding.MULTIPART_FORM_DATA -> FormEncType.multipartFormData
    FormEncoding.APPLICATION_X_WWW_FORM_URL_ENCODED -> FormEncType.applicationXWwwFormUrlEncoded
    FormEncoding.TEXT_PLAIN -> FormEncType.textPlain
}

private fun FormMethod.toHtmlFormMethod(): HtmlFormMethod = when (this) {
    FormMethod.GET -> HtmlFormMethod.get
    FormMethod.POST -> HtmlFormMethod.post
}