package dev.syncended.kube.utils

import kotlinx.html.Tag

fun Tag.attr(name: String): String? {
  return attributes[name]
}

fun Tag.setAttr(name: String, value: String?) {
  if (value == null) {
    attributes.remove(name)
  } else {
    attributes[name] = value
  }
}
