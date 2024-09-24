package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.KubePlugin

object KubePlugins : KubePlugin.PluginsWrapper {
  override val plugins: Set<KubePlugin>
    get() = setOf(
      ViewportPlugin,
      MainCssPlugin,
      StylingPlugin,
      ModifierStylingPlugin,
    )
}