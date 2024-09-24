package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.model.ResourceMode

class KubeResourcesPlugin(
  override val mode: ResourceMode = ResourceMode.FAT,
  prefix: String = ""
) : KubePlugin.Resources {
  override val prefix: String = prefix.trim('/')
}