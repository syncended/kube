package dev.syncended.kube.core.widget.core

import kotlinx.css.TagSelector

val all = selector("*")
val text = classSelector(Design.Class.TEXT)
val inline = classSelector(Design.Class.INLINE)

private fun classSelector(name: String): TagSelector = selector(".$name")
private fun selector(value: String): TagSelector = TagSelector(value)