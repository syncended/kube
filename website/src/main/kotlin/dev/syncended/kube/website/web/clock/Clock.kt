package dev.syncended.kube.website.web.clock

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.model.toClassSelector
import dev.syncended.kube.dsl.box
import dev.syncended.kube.dsl.text
import dev.syncended.kube.htmx.model.HxSwap
import dev.syncended.kube.htmx.modifier.hxGet
import dev.syncended.kube.htmx.modifier.hxSwap
import dev.syncended.kube.htmx.modifier.hxTarget
import dev.syncended.kube.htmx.modifier.hxTrigger
import java.text.SimpleDateFormat
import java.util.Date

private val clockContainer = "clock-container".toClassSelector()
private val sdf = SimpleDateFormat("HH:mm:ss")
private val formattedNow: String
  get() = sdf.format(Date())

fun clockPage(): String = box(mode = RenderMode.VIEW_ONLY, modifier = Modifier.withClass(clockContainer)) {
  clock()
}

fun Layout.clockWidget() = box(Modifier.withClass(clockContainer)) {
  clock()
}

private fun Layout.clock() {
  text(
    text = formattedNow,
    modifier = Modifier.hxGet("/clock")
      .hxSwap(HxSwap.OuterHTML)
      .hxTarget(clockContainer)
      .hxTrigger("every 1s")
  )
}