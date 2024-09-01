package dev.syncended.kube.styling

import dev.syncended.kube.core.model.toClassSelector
import dev.syncended.kube.core.model.toRawSelector
import dev.syncended.kube.core.model.toTagSelector

internal object Selectors {
  // Default tags
  val all = "*".toRawSelector()
  val html = "html".toTagSelector()
  val body = "body".toTagSelector()

  // Custom classes
  val column = "kube-column".toClassSelector()
  val row = "kube-row".toClassSelector()
}