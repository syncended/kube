package dev.syncended.kube.dsl

import dev.syncended.kube.components.Box
import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.Modifier
import dev.syncended.kube.core.RenderMode
import dev.syncended.kube.core.Widget
import dev.syncended.kube.core.modifier

fun render(
  mode: RenderMode = RenderMode.FAT_PAGE,
  body: Box.() -> Unit
): String {
  val root = Box(modifier())
  root.body()
  return Kube.render(mode, root)
}

internal fun <M : Modifier, T : Widget<M>> Layout<*>.widget(
  instance: T,
  body: T.(M) -> Unit = {}
) {
  instance.body(instance.modifier)
  addChild(instance)
}