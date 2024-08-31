package dev.syncended.kube.dsl

import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.Widget

internal fun <T : Widget> Layout.widget(instance: T, body: T.() -> Unit = {}) {
  instance.body()
  addChild(instance)
}