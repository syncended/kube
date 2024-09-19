package dev.syncended.kube.dsl

import dev.syncended.kube.components.Image
import dev.syncended.kube.components.ImageType
import dev.syncended.kube.components.Space
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

fun Layout.space(modifier: Modifier = Modifier) = widget(Space(modifier = modifier))

fun Layout.image(
  imageUrl: String,
  modifier: Modifier = Modifier,
  alt: String? = null
) = image(
  modifier = modifier,
  imageUrl = imageUrl,
  alt = alt,
  base64Image = null,
  base64Type = null
)

fun Layout.image(
  base64Image: String,
  modifier: Modifier = Modifier,
  type: ImageType = ImageType.PNG,
  alt: String? = null,
) = image(
  modifier = modifier,
  imageUrl = null,
  alt = alt,
  base64Image = base64Image,
  base64Type = type
)

fun Layout.image(
  base64Image: ByteArray,
  modifier: Modifier = Modifier,
  type: ImageType = ImageType.PNG,
  alt: String? = null,
) = image(
  modifier = modifier,
  imageUrl = null,
  alt = alt,
  base64Image = @OptIn(ExperimentalEncodingApi::class) Base64.encode(base64Image),
  base64Type = type
)

private fun Layout.image(
  modifier: Modifier,
  imageUrl: String?,
  base64Image: String?,
  base64Type: ImageType?,
  alt: String?,
) = widget(
  instance = Image(
    modifier = modifier,
    imageUrl = imageUrl,
    base64Image = base64Image,
    base64Type = base64Type,
    alt = alt
  )
)
