package dev.syncended.kube.spring.htmx.configuration

import dev.syncended.kube.core.Kube
import dev.syncended.kube.htmx.KubeHtmxPlugins
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.ComponentScan

@AutoConfiguration
@ComponentScan("dev.syncended.kube.spring.htmx")
open class KubeHtmxConfiguration {

  init {
    Kube.install(KubeHtmxPlugins)
  }
}