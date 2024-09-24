package dev.syncended.kube.core

internal class PluginsHolder {
  private val _head = mutableSetOf<KubePlugin.HeadAppender>()
  val head: Set<KubePlugin.HeadAppender> get() = _head
  private val _styling = mutableSetOf<KubePlugin.Styling>()
  val styling: Set<KubePlugin.Styling> get() = _styling
  private val _modifierStyling = mutableSetOf<KubePlugin.ModifierStyling>()
  val modifierStyling: Set<KubePlugin.ModifierStyling> get() = _modifierStyling
  private val _modifierAttributes = mutableSetOf<KubePlugin.ModifierAttributes>()
  val modifierAttributes: Set<KubePlugin.ModifierAttributes> get() = _modifierAttributes

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
    }
  }

  private fun install(plugin: KubePlugin) {
    when (plugin) {
      is KubePlugin.PluginsWrapper -> install(plugin.plugins.toSet())
      is KubePlugin.ModifierStyling -> _modifierStyling += plugin
      is KubePlugin.ModifierAttributes -> _modifierAttributes += plugin
      is KubePlugin.HeadAppender -> _head += plugin
      is KubePlugin.Styling -> _styling += plugin
    }
  }
}