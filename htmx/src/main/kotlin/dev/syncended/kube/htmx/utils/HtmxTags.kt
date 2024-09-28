package dev.syncended.kube.htmx.utils

import dev.syncended.kube.utils.setAttr
import kotlinx.html.Tag


internal var Tag.hxGet: String
  get() = error("Write only attr")
  set(value) = this.setAttr("hx-get", value)
internal var Tag.hxPost: String
  get() = error("Write only attr")
  set(value) = this.setAttr("hx-post", value)
internal var Tag.hxPut: String
  get() = error("Write only attr")
  set(value) = this.setAttr("hx-put", value)
internal var Tag.hxDelete: String
  get() = error("Write only attr")
  set(value) = this.setAttr("hx-delete", value)