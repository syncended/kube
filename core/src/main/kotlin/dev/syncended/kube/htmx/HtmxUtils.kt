package dev.syncended.kube.htmx

import loadResource

fun htmxMinJs(): String {
  return loadResource("/js/htmx.min.js")
    ?.let { String(it) }
    .orEmpty()
}