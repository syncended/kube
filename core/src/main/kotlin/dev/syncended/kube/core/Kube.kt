package dev.syncended.kube.core

import dev.syncended.kube.core.component.Widget
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.styling.Fonts
import dev.syncended.kube.core.styling.KubeStyling.buildStyle
import dev.syncended.kube.utils.setAttr
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.meta
import kotlinx.html.style
import kotlinx.html.unsafe

object Kube {
  private var _resourceMode = ResourceMode.FAT
  internal val resourceMode: ResourceMode get() = _resourceMode

  fun setResourceMode(mode: ResourceMode) {
    _resourceMode = mode
  }

  internal fun render(mode: RenderMode, root: Widget<*>): String {
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
      style { unsafe { +buildStyle() } }
    }
  }
}