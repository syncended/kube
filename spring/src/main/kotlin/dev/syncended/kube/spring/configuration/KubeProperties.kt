package dev.syncended.kube.spring.configuration

import dev.syncended.kube.core.model.ResourceMode
import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "kube")
data class KubeProperties(
  val resources: KubeResources = KubeResources(),
  var useHtmx: Boolean = false
)

data class KubeResources(
  var mode: ResourceMode = ResourceMode.LINK,
  var prefix: String = "static"
)