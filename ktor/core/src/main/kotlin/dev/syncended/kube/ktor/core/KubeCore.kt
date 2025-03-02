package dev.syncended.kube.ktor.core

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.model.ResourceMode
import io.ktor.server.application.createApplicationPlugin
import io.ktor.server.routing.routing

class KubeCorePluginConfiguration(
  var resourceMode: ResourceMode = ResourceMode.LINK,
  var resourcePrefix: String = "static"
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

  if (pluginConfig.resourceMode == ResourceMode.LINK) application.routing {
    resourcesRouting(pluginConfig.resourcePrefix)
  }
}