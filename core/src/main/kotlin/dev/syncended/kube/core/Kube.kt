package dev.syncended.kube.core

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.plugins.KubePlugins
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html

object Kube {
  internal val plugins = PluginsHolder()
  internal var settings = Settings()

  val resources: Resources get() = settings.resources

  init {
    install(KubePlugins)
  }

  fun install(vararg plugins: KubePlugin) {
    this.plugins.install(plugins.toSet())
  }

  fun remove(plugin: KubePlugin) {
    plugins.remove(plugin)
  }

  fun settings(builder: SettingsBuilder.() -> Unit) {
    val settings = SettingsBuilder.newInstance()
    settings.builder()
    this.settings = settings.build()
  }

  fun applySettings(builder: SettingsBuilder) {
    settings = builder.build()
  }

  internal fun render(mode: RenderMode, root: Widget): String {
    return createHTMLDocument().html {
      renderHead(mode)
      body { root.render(this) }
    }.serialize(prettyPrint = false) // For markdown support, find better solution
  }

  private fun HTML.renderHead(mode: RenderMode) {
    if (mode == RenderMode.VIEW_ONLY) return
    head {
      plugins.head.forEach { it.apply(this) }
    }
  }
}