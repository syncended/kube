package dev.syncended.kube.website.application

import dev.syncended.kube.spring.configuration.KubeConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@Import(KubeConfiguration::class)
@SpringBootApplication
open class KubeWebsiteApplication {
  companion object {
    @JvmStatic
    fun main(vararg args: String) {
      SpringApplication.run(KubeWebsiteApplication::class.java, *args)
    }
  }
}