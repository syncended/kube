package dev.syncended.kube.htmx.utils

import loadResource

val htmxSource by lazy {
  loadResource("/js/htmx.min.js")
    ?.let { String(it) }
    ?: ""
}