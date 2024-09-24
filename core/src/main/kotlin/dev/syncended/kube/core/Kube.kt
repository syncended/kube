package dev.syncended.kube.core

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.plugins.KubePlugins
import dev.syncended.kube.htmx.htmxMinJs
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.script
import kotlinx.html.unsafe

object Kube {
  internal val plugins = PluginsHolder()

  private var _resourcesPrefix: String = ""
  internal val resourcesPrefix: String get() = _resourcesPrefix

  private var _resourceMode = ResourceMode.FAT
  internal val resourceMode: ResourceMode get() = _resourceMode

  private var isHtmxEnabled = false

  init {
    install(KubePlugins)
  }

  fun install(vararg plugins: KubePlugin) {
    this.plugins.install(plugins.toSet())
  }

  fun remove(plugin: KubePlugin) {
    plugins.remove(plugin)
  }

  fun setResourceMode(mode: ResourceMode) {
    _resourceMode = mode
  }

  fun setResourcePrefix(prefix: String) {
    _resourcesPrefix = prefix.trim('/')
  }

  fun setHtmxEnabled(isEnabled: Boolean) {
    isHtmxEnabled = isEnabled
  }

  internal fun render(mode: RenderMode, root: Widget): String {
    return createHTMLDocument().html {
      renderHead(mode)
      body { root.render(this) }
    }.serialize()
  }

  private fun HTML.renderHead(mode: RenderMode) {
    if (mode == RenderMode.VIEW_ONLY) return
    head {
      plugins.head.forEach { it.apply(this) }
      if (resourceMode == ResourceMode.FAT) {
        if (isHtmxEnabled) script { unsafe { +htmxMinJs() } }
      } else {
        if (isHtmxEnabled) script { src = "/$resourcesPrefix/js/htmx.min.js" }
      }
    }
  }
}