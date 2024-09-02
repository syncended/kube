package dev.syncended.kube.website.ui.components

import dev.syncended.kube.components.Text
import dev.syncended.kube.components.fontSize
import dev.syncended.kube.components.textSize
import dev.syncended.kube.core.component.AnyLayout
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.dsl.text
import dev.syncended.kube.website.ui.styling.Sizes.fontSizeDefault
import dev.syncended.kube.website.ui.styling.Sizes.fontSizeHeader

fun AnyLayout.heading(text: String, body: Text.() -> Unit = {}) = text(text) {
  modifier.textSize(fontSizeHeader)
    .fontSize(fontSize = FontSize.Bold)
  body.invoke(this)
}

fun AnyLayout.title(text: String, body: Text.() -> Unit = {}) = text(text) {
  modifier.textSize(fontSizeDefault)
    .fontSize(fontSize = FontSize.Bold)
  body.invoke(this)
}