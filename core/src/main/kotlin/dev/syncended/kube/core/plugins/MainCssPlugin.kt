package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.Kube.resourcesPrefix
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.KubeStyling.buildStyle
import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.style
import kotlinx.html.unsafe

object MainCssPlugin : KubePlugin.HeadAppender {
  override fun apply(head: HEAD) {
    if (Kube.resourceMode == ResourceMode.FAT) {
      head.style { unsafe { +buildStyle() } }
    } else {
      head.link {
        rel = "stylesheet"
        href = "/$resourcesPrefix/css/main.css"
      }
    }
  }
}