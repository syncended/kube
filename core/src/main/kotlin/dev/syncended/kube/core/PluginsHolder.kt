package dev.syncended.kube.core

import dev.syncended.kube.core.plugins.KubeResourcesPlugin

internal class PluginsHolder {
  private val _head = mutableSetOf<KubePlugin.HeadAppender>()
  private val _styling = mutableSetOf<KubePlugin.Styling>()
  private val _modifierStyling = mutableSetOf<KubePlugin.ModifierStyling>()
  private val _modifierAttributes = mutableSetOf<KubePlugin.ModifierAttributes>()

  val head: Set<KubePlugin.HeadAppender> get() = _head
  val styling: Set<KubePlugin.Styling> get() = _styling
  val modifierStyling: Set<KubePlugin.ModifierStyling> get() = _modifierStyling
  val modifierAttributes: Set<KubePlugin.ModifierAttributes> get() = _modifierAttributes

  var resources: KubePlugin.Resources = KubeResourcesPlugin()
    private set

  fun install(plugins: Set<KubePlugin>) {
    plugins.forEach { install(it) }
  }

  fun remove(plugin: KubePlugin) {
    when (plugin) {
      is KubePlugin.PluginsWrapper -> plugin.plugins.forEach { remove(it) }
      is KubePlugin.ModifierStyling -> _modifierStyling -= plugin
      is KubePlugin.ModifierAttributes -> _modifierAttributes -= plugin
      is KubePlugin.HeadAppender -> _head -= plugin
      is KubePlugin.Styling -> _styling -= plugin
      is KubePlugin.Resources -> resources = KubeResourcesPlugin()
    }
  }

  private fun install(plugin: KubePlugin) {
    when (plugin) {
      is KubePlugin.PluginsWrapper -> install(plugin.plugins.toSet())
      is KubePlugin.ModifierStyling -> _modifierStyling += plugin
      is KubePlugin.ModifierAttributes -> _modifierAttributes += plugin
      is KubePlugin.HeadAppender -> _head += plugin
      is KubePlugin.Styling -> _styling += plugin
      is KubePlugin.Resources -> resources = plugin
    }
  }
}