package dev.syncended.kube.dsl

import dev.syncended.kube.components.Link
import dev.syncended.kube.components.LinkModifier
import dev.syncended.kube.components.Text
import dev.syncended.kube.components.TextModifier
import dev.syncended.kube.components.href
import dev.syncended.kube.components.text
import dev.syncended.kube.core.component.Layout

fun Layout<*>.text(text: String, body: Text.() -> Unit = {}) = text {
  modifier.text(text)
  body.invoke(this)
}

fun Layout<*>.text(body: Text.() -> Unit = {}) = widget(
  instance = Text(TextModifier()),
  body = body
)

fun Layout<*>.link(text: String, href: String, body: Link.() -> Unit = {}) = link {
  modifier.href(href).text(text)
  body.invoke(this)
}

fun Layout<*>.link(body: Link.() -> Unit = {}) = widget(
  instance = Link(LinkModifier()),
  body = body
)