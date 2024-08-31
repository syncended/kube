package dev.syncended.kube.dsl

import dev.syncended.kube.components.Text
import dev.syncended.kube.core.Layout

fun Layout.text(text: String) = widget(Text(text))