package dev.syncended.kube.htmx

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.htmx.plugins.HtmxModifierAttributesPlugin
import dev.syncended.kube.htmx.plugins.HtmxScriptPlugin

object KubeHtmxPlugins : KubePlugin.PluginsWrapper {
  override val plugins: Set<KubePlugin>
    get() = setOf(
      HtmxScriptPlugin,
      HtmxModifierAttributesPlugin
    )
}