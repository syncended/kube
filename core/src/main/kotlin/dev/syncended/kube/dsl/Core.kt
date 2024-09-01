package dev.syncended.kube.dsl

import dev.syncended.kube.components.Box
import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.RenderMode
import dev.syncended.kube.core.Widget

fun render(
  mode: RenderMode = RenderMode.FAT_PAGE,
  body: Layout.() -> Unit
): String {
  val root = Box()
  root.body()
  return Kube.render(mode, root)
}

internal fun <T : Widget> Layout.widget(instance: T, body: T.() -> Unit = {}) {
  instance.body()
  addChild(instance)
}