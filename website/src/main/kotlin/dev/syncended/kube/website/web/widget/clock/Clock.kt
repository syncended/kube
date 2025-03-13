package dev.syncended.kube.website.web.widget.clock

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.withClass
import dev.syncended.kube.core.model.RenderMode
import dev.syncended.kube.core.model.toClassSelector
import dev.syncended.kube.dsl.render
import dev.syncended.kube.dsl.text
import dev.syncended.kube.htmx.model.HxSwap
import dev.syncended.kube.htmx.modifier.hxGet
import dev.syncended.kube.htmx.modifier.hxSwap
import dev.syncended.kube.htmx.modifier.hxTarget
import dev.syncended.kube.htmx.modifier.hxTrigger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.Date

private val clockContainer = "clock-container".toClassSelector()
private val sdf = SimpleDateFormat("HH:mm:ss")
private val formattedNow: String
  get() = sdf.format(Date())

@RestController
class ClockController {

  @GetMapping("/clock")
  fun getClock() = render(mode = RenderMode.VIEW_ONLY) { clock() }
}

fun Layout.clock() {
  text(
    text = formattedNow,
    modifier = Modifier.hxGet("/clock")
      .hxSwap(HxSwap.OuterHTML)
      .hxTarget(clockContainer)
      .hxTrigger("every 1s")
      .withClass(clockContainer)
  )
}