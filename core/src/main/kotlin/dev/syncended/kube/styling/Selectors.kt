package dev.syncended.kube.styling

import dev.syncended.kube.core.toClassSelector
import dev.syncended.kube.core.toRawSelector
import dev.syncended.kube.core.toTagSelector

object Selectors {
  // Default tags
  val all = "*".toRawSelector()
  val html = "html".toTagSelector()
  val body = "body".toTagSelector()

  // Custom classes
  val column = "kube-column".toClassSelector()
}