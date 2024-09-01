package dev.syncended.kube.components

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.Widget
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private val BASE_64_TEMPLATE = "data:image/png;base64, %s"

class Image(modifier: ImageModifier) : Widget<ImageModifier>(modifier) {
  override fun render() = img {
    modifier.imageUrl?.let { src = it }
    modifier.base64Image?.let { src = BASE_64_TEMPLATE.format(it) }
    modifier.alt?.let { alt = it }
  }
}

class ImageModifier : Modifier() {
  var imageUrl: String? = null
  var base64Image: String? = null
  var alt: String? = null
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

fun ImageModifier.rawBase64Image(image: String): ImageModifier {
  base64Image = image
  return this
}

fun ImageModifier.alt(value: String): ImageModifier {
  alt = value
  return this
}
