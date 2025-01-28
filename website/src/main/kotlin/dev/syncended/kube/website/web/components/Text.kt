package dev.syncended.kube.website.web.components

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.core.model.FontStyle
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.web.styling.Sizes.fontSizeDefault
import dev.syncended.kube.website.web.styling.Sizes.fontSizeHeader

fun Layout.heading(
  text: String,
  modifier: Modifier = Modifier,
  color: Color? = null,
  textSize: Size? = fontSizeHeader,
  fontSize: FontSize? = FontSize.Bold,
  fontStyle: FontStyle? = null,
) = text(
  text = text,
  modifier = modifier,
  color = color,
  textSize = textSize,
  fontSize = fontSize,
  fontStyle = fontStyle
)

fun Layout.title(
  text: String,
  modifier: Modifier = Modifier,
  color: Color? = null,
  textSize: Size? = fontSizeDefault,
  fontSize: FontSize? = FontSize.Bold,
  fontStyle: FontStyle? = null,
) = text(
  text = text,
  modifier = modifier,
  color = color,
  textSize = textSize,
  fontSize = fontSize,
  fontStyle = fontStyle
)
