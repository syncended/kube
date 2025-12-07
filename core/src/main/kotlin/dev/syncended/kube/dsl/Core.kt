package dev.syncended.kube.dsl

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.component.Widget

inline fun <T : Widget> widget(
  mode: RenderMode = RenderMode.VIEW_ONLY,
  instance: T,
  body: T.() -> Unit
): String {
  instance.body()
  return Kube.render(mode, instance)
}

inline fun <T : Widget> Layout.widget(
  instance: T,
  body: T.() -> Unit = {}
) {
  instance.body()
  addChild(instance)
}