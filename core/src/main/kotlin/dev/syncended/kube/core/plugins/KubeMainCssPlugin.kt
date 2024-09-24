package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.Kube.plugins
import dev.syncended.kube.core.Kube.resourcesPrefix
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.KubeStyling.buildStyle
import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.style
import kotlinx.html.unsafe

object KubeMainCssPlugin : KubePlugin.HeadAppender {
  override fun apply(head: HEAD) {
    when (plugins.resources) {
      KubePlugin.Resources.Fat -> head.style { unsafe { +buildStyle() } }
      KubePlugin.Resources.Link -> head.link {
        rel = "stylesheet"
        href = "/$resourcesPrefix/css/main.css"
      }
    }
  }
}