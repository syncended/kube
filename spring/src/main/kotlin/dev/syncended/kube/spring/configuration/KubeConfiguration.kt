package dev.syncended.kube.spring.configuraiton

import dev.syncended.kube.core.Kube
import dev.syncended.kube.spring.configuration.KubeProperties
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@AutoConfiguration
@ComponentScan("dev.syncended.kube.spring")
@EnableConfigurationProperties(KubeProperties::class)
open class KubeConfiguration(properties: KubeProperties) {

  init {
    Kube.setResourceMode(properties.resources.mode)
    Kube.setResourcePrefix(properties.resources.prefix)
  }
}