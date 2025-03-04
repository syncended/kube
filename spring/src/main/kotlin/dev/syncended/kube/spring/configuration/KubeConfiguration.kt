package dev.syncended.kube.spring.configuration

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.htmx.KubeHtmxPlugins
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@AutoConfiguration
@ComponentScan("dev.syncended.kube.spring")
@EnableConfigurationProperties(KubeProperties::class)
open class KubeConfiguration(properties: KubeProperties) {

  init {
    val resourcesPlugin = KubePlugin.Resources(
      mode = properties.resources.mode,
      prefix = properties.resources.prefix
    )
    Kube.install(resourcesPlugin)
    if (properties.htmx) Kube.install(KubeHtmxPlugins)
  }
}