package dev.syncended.kube.htmx.plugins

import dev.syncended.kube.core.Kube.resources
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.model.ResourceMode
import kotlinx.html.HEAD
import kotlinx.html.script
import kotlinx.html.unsafe
import loadResource
import trimSlashes


object HtmxScriptPlugin : KubePlugin.HeadAppender {
  val htmxSource by lazy {
    loadResource("/js/htmx.min.js")
      ?.let { String(it) }
      ?: ""
  }

  override fun apply(head: HEAD) {
    head.script {
      when (resources.mode) {
        ResourceMode.FAT -> unsafe { +htmxSource }
        ResourceMode.LINK -> src = "/${resources.prefix}/js/htmx.min.js".trimSlashes()
      }
    }
  }
}