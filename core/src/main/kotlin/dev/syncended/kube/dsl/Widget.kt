package dev.syncended.kube.dsl

import dev.syncended.kube.components.Image
import dev.syncended.kube.components.ImageModifier
import dev.syncended.kube.components.Space
import dev.syncended.kube.components.alt
import dev.syncended.kube.components.base64Image
import dev.syncended.kube.components.imageUrl
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

fun Layout<*>.space(modifier: Modifier) = widget(Space(modifier))

fun Layout<*>.image(url: String, alt: String? = null, body: Image.() -> Unit = {}) = widget(
  instance = Image(ImageModifier().imageUrl(url).alt(alt)),
  body = body
)

fun Layout<*>.image(rawImage: ByteArray, alt: String? = null, body: Image.() -> Unit = {}) = widget(
  instance = Image(ImageModifier().base64Image(rawImage).alt(alt)),
  body = body
)

fun Layout<*>.image(body: Image.() -> Unit = {}) = widget(
  instance = Image(ImageModifier()),
  body = body
)