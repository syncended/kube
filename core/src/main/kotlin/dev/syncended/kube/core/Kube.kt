package dev.syncended.kube.core

import dev.syncended.kube.core.configuration.KubeConfig

object Kube {
  private var config: KubeConfig = defaultConfig()

  fun init() {

  }

  private fun defaultConfig() = KubeConfig()

  internal fun config(): KubeConfig = config
}