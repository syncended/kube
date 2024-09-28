package dev.syncended.kube.htmx.utils

import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.htmx.model.HxSwap
import dev.syncended.kube.utils.setAttr
import kotlinx.html.SELECT
import kotlinx.html.Tag

internal var Tag.hxGet: String
  get() = writeOnly()
  set(value) = this.setAttr("hx-get", value)
internal var Tag.hxPost: String
  get() = writeOnly()
  set(value) = this.setAttr("hx-post", value)
internal var Tag.hxPut: String
  get() = writeOnly()
  set(value) = this.setAttr("hx-put", value)
internal var Tag.hxDelete: String
  get() = writeOnly()
  set(value) = this.setAttr("hx-delete", value)
internal var Tag.hxTarget: Selector
  get() = writeOnly()
  set(value) = this.setAttr("hx-target", value.toRawSelector())
internal var Tag.hxIndicator: Selector
  get() = writeOnly()
  set(value) = this.setAttr("hx-indicator", value.toRawSelector())
internal var Tag.hxSwap: HxSwap
  get() = writeOnly()
  set(value) = this.setAttr("hx-swap", value.value)
internal var Tag.hxTrigger: String
  get() = writeOnly()
  set(value) = this.setAttr("hx-trigger", value)

private fun writeOnly(): Nothing = error("Write only attr")