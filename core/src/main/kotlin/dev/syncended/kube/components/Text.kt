package dev.syncended.kube.components

import dev.syncended.kube.core.Widget

class Text(
  private val text: String
) : Widget() {

  override fun render() = p {
    +text
  }
}