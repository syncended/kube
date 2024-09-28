package dev.syncended.kube.core

internal class PluginsHolder {
  private val _head = mutableSetOf<KubePlugin.HeadAppender>()
  private val _styling = mutableSetOf<KubePlugin.Styling>()
  private val _modifierStyling = mutableSetOf<KubePlugin.ModifierStyling>()
  private val _modifierAttributes = mutableSetOf<KubePlugin.ModifierAttributes>()
  private val _fonts = mutableSetOf<KubePlugin.FontResource>()

  val head: Set<KubePlugin.HeadAppender> get() = _head
  val styling: Set<KubePlugin.Styling> get() = _styling
  val modifierStyling: Set<KubePlugin.ModifierStyling> get() = _modifierStyling
  val modifierAttributes: Set<KubePlugin.ModifierAttributes> get() = _modifierAttributes
  val fonts: Set<KubePlugin.FontResource> get() = _fonts

  var defaultFont: KubePlugin.DefaultFontResource? = null
    private set
  var resources: KubePlugin.Resources = KubePlugin.Resources()
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
      is KubePlugin.Resources -> resources = KubePlugin.Resources()
      is KubePlugin.FontResource -> _fonts -= plugin
      is KubePlugin.DefaultFontResource -> defaultFont = null
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
      is KubePlugin.FontResource -> _fonts += plugin
      is KubePlugin.DefaultFontResource -> {
        install(plugin.toFontResource())
        defaultFont = plugin
      }
    }
  }

  private fun KubePlugin.DefaultFontResource.toFontResource(): KubePlugin.FontResource {
    return KubePlugin.FontResource(font)
  }
}