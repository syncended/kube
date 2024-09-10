package dev.syncended.kube.spring.utils

import dev.syncended.kube.core.model.FontResource
import dev.syncended.kube.core.model.extension
import org.springframework.http.MediaType

internal val FontResource.contentType: MediaType
  get() = when (extension.lowercase()) {
    "woff2" -> MediaType.valueOf("application/x-font-woff")
    else -> MediaType.valueOf("font/ttf")
  }