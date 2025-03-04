package dev.syncended.kube.ktor.core

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.htmx.KubeHtmxPlugins
import io.ktor.server.application.createApplicationPlugin
import io.ktor.server.routing.routing

class KubeCorePluginConfiguration(
  var resourceMode: ResourceMode = ResourceMode.LINK,
  var resourcePrefix: String = "static",
  var useHtmx: Boolean = false,
)

val KubeCore = createApplicationPlugin(
  "KubeCorePlugin",
  createConfiguration = ::KubeCorePluginConfiguration,
) {
  val resourcesPlugin = KubePlugin.Resources(
    mode = pluginConfig.resourceMode,
    prefix = pluginConfig.resourcePrefix
  )
  Kube.install(resourcesPlugin)
  if (pluginConfig.useHtmx) Kube.install(KubeHtmxPlugins)

  if (pluginConfig.resourceMode == ResourceMode.LINK) application.routing {
    resourcesRouting(pluginConfig)
  }
}