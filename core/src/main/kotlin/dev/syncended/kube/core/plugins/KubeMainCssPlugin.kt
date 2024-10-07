package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.Kube.settings
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.KubeStyling.buildStyle
import dev.syncended.kube.core.model.ResourceMode
import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.style
import kotlinx.html.unsafe
import trimSlashes

object KubeMainCssPlugin : KubePlugin.HeadAppender {
  override fun apply(head: HEAD) {
    when (settings.resources.mode) {
      ResourceMode.FAT -> head.style { unsafe { +buildStyle() } }
      ResourceMode.LINK -> head.link {
        rel = "stylesheet"
        href = "/${settings.resources.prefix}/css/main.css".trimSlashes()
      }
    }
  }
}