package dev.syncended.kube.components

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.Widget
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private val BASE_64_TEMPLATE = "data:image/%s;base64, %s"

class Image(modifier: ImageModifier) : Widget<ImageModifier>(modifier) {
  override fun render() = img {
    modifier.imageUrl?.let { src = it }
    modifier.base64Image?.let {
      val type = modifier.base64Type ?: ImageType.PNG
      src = BASE_64_TEMPLATE.format(type.value, it)
    }
    modifier.alt?.let { alt = it }
  }
}

enum class ImageType(internal val value: String) {
  PNG("png"), SVG("svg+xml")
}

class ImageModifier : Modifier() {
  internal var imageUrl: String? = null
  internal var base64Image: String? = null
  internal var base64Type: ImageType? = null
  internal var alt: String? = null
}

fun ImageModifier.imageUrl(url: String): ImageModifier {
  imageUrl = url
  return this
}

fun ImageModifier.base64Image(bytes: ByteArray): ImageModifier {
  @OptIn(ExperimentalEncodingApi::class)
  val content = Base64.encode(bytes)
  base64Image = content
  return this
}

fun ImageModifier.base64Type(type: ImageType): ImageModifier {
  base64Type = type
  return this
}

fun ImageModifier.rawBase64Image(image: String): ImageModifier {
  base64Image = image
  return this
}

fun ImageModifier.alt(value: String?): ImageModifier {
  alt = value
  return this
}
