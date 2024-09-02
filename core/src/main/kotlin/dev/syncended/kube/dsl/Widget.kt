package dev.syncended.kube.dsl

import dev.syncended.kube.components.Image
import dev.syncended.kube.components.ImageModifier
import dev.syncended.kube.components.ImageType
import dev.syncended.kube.components.Space
import dev.syncended.kube.components.alt
import dev.syncended.kube.components.base64Image
import dev.syncended.kube.components.base64Type
import dev.syncended.kube.components.imageUrl
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

fun Layout<*>.space(body: Space.() -> Unit) = widget(Space(Modifier()), body)

fun Layout<*>.image(url: String, alt: String? = null, body: Image.() -> Unit = {}) = widget(
  instance = Image(ImageModifier().imageUrl(url).alt(alt)),
  body = body
)

fun Layout<*>.image(
  rawImage: ByteArray,
  type: ImageType = ImageType.PNG,
  alt: String? = null,
  body: Image.() -> Unit = {}
) = widget(
  instance = Image(
    ImageModifier()
      .base64Image(rawImage)
      .base64Type(type)
      .alt(alt)
  ),
  body = body
)

fun Layout<*>.svgImage(
  rawImage: ByteArray,
  alt: String? = null,
  body: Image.() -> Unit = {}
) = image(rawImage = rawImage, type = ImageType.SVG, alt = alt, body)

fun Layout<*>.image(body: Image.() -> Unit = {}) = widget(
  instance = Image(ImageModifier()),
  body = body
)