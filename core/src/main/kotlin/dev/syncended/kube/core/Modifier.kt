package dev.syncended.kube.core


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

internal inline fun <reified T : Modifier> modifier(): T {
  val constructor = T::class.constructors.find { it.parameters.isEmpty() }
    ?: error("Modifier implementation must contains no-args constructor")
  return constructor.call()
}