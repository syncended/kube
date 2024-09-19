package dev.syncended.kube.core.modifier

import dev.syncended.kube.core.component.Modifier
import kotlinx.css.CssBuilder

typealias CssModifier = (CssBuilder, Modifier) -> Unit

object KubeModifiers {
  private val _cssBuilders = mutableListOf<CssModifier>()
  internal val cssBuilders: List<CssModifier> get() = _cssBuilders

  fun addBuilder(builder: CssModifier) {
    _cssBuilders.add(builder)
  }
}