package dev.syncended.kube.website.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KubeWebsiteApplication {
  companion object {
    @JvmStatic
    fun main(vararg args: String) {
      SpringApplication.run(KubeWebsiteApplication::class.java, *args)
    }
  }
}