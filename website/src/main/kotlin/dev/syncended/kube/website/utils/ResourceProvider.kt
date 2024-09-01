package dev.syncended.kube.website.utils

import jakarta.annotation.PostConstruct
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

@Component
class ResourceProvider(
  private val resourceLoader: ResourceLoader
) {

  @PostConstruct
  fun postConstruct() {
    instance = this
  }

  fun load(location: String): ByteArray {
    val res = resourceLoader.getResource("classpath:$location")
    return res.contentAsByteArray
  }

  companion object {
    private var instance: ResourceProvider? = null

    fun loadResource(path: String): Lazy<ByteArray> = lazy {
      instance?.load(path)
        ?: error("ResourceProvider was not initialized")
    }
  }
}