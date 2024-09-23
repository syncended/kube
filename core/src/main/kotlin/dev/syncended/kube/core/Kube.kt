package dev.syncended.kube.core

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.styling.KubeStyling.buildStyle
import dev.syncended.kube.htmx.htmxMinJs
import dev.syncended.kube.utils.setAttr
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.style
import kotlinx.html.unsafe

object Kube {
  private val plugins = mutableSetOf<KubePlugin>()

  private var _resourcesPrefix: String = ""
  internal val resourcesPrefix: String get() = _resourcesPrefix

  private var _resourceMode = ResourceMode.FAT
  internal val resourceMode: ResourceMode get() = _resourceMode

  private var isHtmxEnabled = false

  fun install(vararg plugins: KubePlugin) {
    this.plugins.addAll(plugins)
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
      meta {
        name = "viewport"
        content = "width=device-width"
        setAttr("initial-scale", "1.0")
        setAttr("user-scalable", "no")
      }
      if (resourceMode == ResourceMode.FAT) {
        style { unsafe { +buildStyle() } }
        if (isHtmxEnabled) script { unsafe { +htmxMinJs() } }
      } else {
        link {
          rel = "stylesheet"
          href = "/$resourcesPrefix/css/main.css"
        }
        if (isHtmxEnabled) script { src = "/$resourcesPrefix/js/htmx.min.js" }
      }
    }
  }
}