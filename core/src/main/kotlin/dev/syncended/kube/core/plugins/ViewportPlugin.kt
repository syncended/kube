package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.utils.setAttr
import kotlinx.html.HEAD
import kotlinx.html.meta

object ViewportPlugin : KubePlugin.HeadAppender {
  override fun apply(head: HEAD) {
    head.meta {
      name = "viewport"
      content = "width=device-width"
      setAttr("initial-scale", "1.0")
      setAttr("user-scalable", "no")
    }
  }
}