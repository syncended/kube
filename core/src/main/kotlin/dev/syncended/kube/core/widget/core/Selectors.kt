package dev.syncended.kube.core.widget.core

import kotlinx.css.TagSelector

val all = selector("*")
val text = classSelector(Design.Class.TEXT)
val inline = classSelector(Design.Class.INLINE)
val gravityStart = classSelector(Design.Class.GRAVITY_START)
val gravityCenter = classSelector(Design.Class.GRAVITY_CENTER)
val gravityEnd = classSelector(Design.Class.GRAVITY_END)

private fun classSelector(name: String): TagSelector = selector(".$name")
private fun selector(value: String): TagSelector = TagSelector(value)