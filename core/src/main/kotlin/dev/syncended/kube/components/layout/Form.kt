package dev.syncended.kube.components.layout

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod

class Form(
    modifier: Modifier = Modifier,
    private val action: String? = null,
    private val encoding: FormEncoding? = null,
    private val method: HttpMethod? = null
) : Layout(modifier) {

    override fun render() = form(
        action = action,
        encType = encoding?.toFormEnc(),
        method = method?.toFormMethod()
    ) { renderChild(this) }
}

enum class FormEncoding {
    MULTIPART_FORM_DATA,
    APPLICATION_X_WWW_FORM_URL_ENCODED,
    TEXT_PLAIN,
}

enum class HttpMethod {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE
}

private fun FormEncoding.toFormEnc(): FormEncType = when (this) {
    FormEncoding.MULTIPART_FORM_DATA -> FormEncType.multipartFormData
    FormEncoding.APPLICATION_X_WWW_FORM_URL_ENCODED -> FormEncType.applicationXWwwFormUrlEncoded
    FormEncoding.TEXT_PLAIN -> FormEncType.textPlain
}

private fun HttpMethod.toFormMethod(): FormMethod = when (this) {
    HttpMethod.GET -> FormMethod.get
    HttpMethod.POST -> FormMethod.post
    HttpMethod.PUT -> FormMethod.put
    HttpMethod.PATCH -> FormMethod.patch
    HttpMethod.DELETE -> FormMethod.delete
}