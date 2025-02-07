package dev.syncended.kube.styling

import dev.syncended.kube.core.model.appendName
import dev.syncended.kube.core.model.toClassSelector
import dev.syncended.kube.core.model.toRawSelector
import dev.syncended.kube.core.model.toTagSelector

internal object Selectors {
  // Default tags
  val all = "*".toRawSelector()
  val html = "html".toTagSelector()
  val body = "body".toTagSelector()

  // Custom classes
  val box = "kube-box".toClassSelector()
  val column = "kube-column".toClassSelector()
  val row = "kube-row".toClassSelector()
  val card = "kube-card".toClassSelector()
  val link = "kube-link".toClassSelector()

  val dynamicMobile = "kube-dynamic-mobile".toClassSelector()
  val dynamicDesktop = "kube-dynamic-desktop".toClassSelector()

  // Custom selectors
  val linkVisited = link.appendName(":visited")
  val linkLink = link.appendName(":link")

  val boxChild = box.appendName(" > *")
}