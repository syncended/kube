package dev.syncended.kube.dsl

import dev.syncended.kube.components.Text
import dev.syncended.kube.components.TextModifier
import dev.syncended.kube.components.text
import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.modifier

fun Layout<*>.text(
  text: String,
  modifier: TextModifier = modifier()
) = widget(Text(modifier.text(text)))