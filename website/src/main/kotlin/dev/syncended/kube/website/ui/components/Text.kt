package dev.syncended.kube.website.ui.components

import dev.syncended.kube.components.Text
import dev.syncended.kube.components.fontSize
import dev.syncended.kube.components.textSize
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.styling.Sizes.sizeFontHeader

fun Layout<*>.title(text: String, body: Text.() -> Unit) = text(text) {
  modifier.textSize(sizeFontHeader)
    .fontSize(fontSize = FontSize.Bold)
  body.invoke(this)
}