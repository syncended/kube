package dev.syncended.kube.core.component

import dev.syncended.kube.core.model.Selector


open class Modifier {
  var id: Selector.Id? = null
  val classes: MutableList<Selector.Class> = mutableListOf()
}

fun <T : Modifier> T.id(value: Selector.Id): T {
  id = value
  return this
}

fun <T : Modifier> T.withClass(className: Selector.Class): T {
  classes.add(className)
  return this
}
