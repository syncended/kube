package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.styling.Fonts

object KubePlugins : KubePlugin.PluginsWrapper {
  override val plugins: Set<KubePlugin>
    get() = setOf(
      KubeViewportPlugin,
      KubeMainCssPlugin,
      KubeStylingPlugin,
      KubeModifierStylingPlugin,
      KubeModifierAttributesPlugin,
      KubePlugin.DefaultFontResource(Fonts.jbMono),
    )
}