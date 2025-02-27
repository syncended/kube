package dev.syncended.kube.dsl

import dev.syncended.kube.components.text.Text
import dev.syncended.kube.components.text.TextLink
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.core.model.FontStyle
import dev.syncended.kube.core.model.Size

fun Layout.text(
  text: String?,
  modifier: Modifier = Modifier,
  color: Color? = null,
  textSize: Size? = null,
  fontSize: FontSize? = null,
  fontStyle: FontStyle? = null,
) = widget(
  instance = Text(
    modifier = modifier,
    color = color,
    textSize = textSize,
    fontSize = fontSize,
    fontStyle = fontStyle,
    text = text
  ),
)

fun Layout.textLink(
  text: String?,
  href: String?,
  modifier: Modifier = Modifier,
  color: Color? = null,
  textSize: Size? = null,
  fontSize: FontSize? = null,
  fontStyle: FontStyle? = null,
) = widget(
  instance = TextLink(
    modifier = modifier,
    color = color,
    textSize = textSize,
    fontSize = fontSize,
    fontStyle = fontStyle,
    text = text,
    href = href
  ),
)