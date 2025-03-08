package dev.syncended.kube.dsl

import dev.syncended.kube.components.layout.Link
import dev.syncended.kube.components.ui.Text
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

fun Layout.link(
  text: String?,
  href: String?,
  modifier: Modifier = Modifier,
  color: Color? = null,
  textSize: Size? = null,
  fontSize: FontSize? = null,
  fontStyle: FontStyle? = null,
) = widget(
  instance = Link(
    modifier = modifier,
    color = color,
    textSize = textSize,
    fontSize = fontSize,
    fontStyle = fontStyle,
    text = text,
    href = href
  ),
)