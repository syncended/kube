package dev.syncended.kube.components.ui

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.Widget

private val BASE_64_TEMPLATE = "data:image/%s;base64, %s"

class Image(
  modifier: Modifier = Modifier,
  private val imageUrl: String? = null,
  private val base64Image: String? = null,
  private val base64Type: ImageType? = null,
  private val alt: String? = null,
) : Widget(modifier) {
  override fun render() = img {
    imageUrl?.let { src = it }
    base64Image?.let {
      val type = base64Type ?: ImageType.PNG
      src = BASE_64_TEMPLATE.format(type.value, it)
    }
    this@Image.alt?.let { alt = it }
  }
}

enum class ImageType(internal val value: String) {
  PNG("png"), SVG("svg+xml")
}
