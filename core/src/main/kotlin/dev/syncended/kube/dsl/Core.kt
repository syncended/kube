package dev.syncended.kube.dsl

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.Modifier
import dev.syncended.kube.core.RenderMode
import dev.syncended.kube.core.Widget

internal fun <M : Modifier, T : Widget<M>> widget(
  mode: RenderMode = RenderMode.VIEW_ONLY,
  instance: T,
  body: T .(M) -> Unit
): String {
  instance.body(instance.modifier)
  return Kube.render(mode, instance)
}

internal fun <M : Modifier, T : Widget<M>> Layout<*>.widget(
  instance: T,
  body: T.(M) -> Unit = {}
) {
  instance.body(instance.modifier)
  addChild(instance)
}