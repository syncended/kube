package dev.syncended.kube.website.ui.clock

import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.text
import java.text.SimpleDateFormat
import java.util.Date

private val sdf = SimpleDateFormat("HH:mm:ss")
private val formattedNow: String
  get() = sdf.format(Date())

fun clock(): String = box(mode = RenderMode.VIEW_ONLY) {
  text(text = formattedNow)
}