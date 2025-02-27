package dev.syncended.kube.website.web.components

import dev.syncended.kube.components.ui.ImageType
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.dsl.image

fun Layout.svgImage(
  image: ByteArray,
  modifier: Modifier = Modifier,
  alt: String? = null,
) = image(
  base64Image = image,
  modifier = modifier,
  type = ImageType.SVG,
  alt = alt
)