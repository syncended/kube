package dev.syncended.kube.htmx.plugins

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.htmx.modifier.hxDelete
import dev.syncended.kube.htmx.modifier.hxGet
import dev.syncended.kube.htmx.modifier.hxIndicator
import dev.syncended.kube.htmx.modifier.hxPost
import dev.syncended.kube.htmx.modifier.hxPut
import dev.syncended.kube.htmx.modifier.hxSwap
import dev.syncended.kube.htmx.modifier.hxTarget
import dev.syncended.kube.htmx.modifier.hxTrigger
import dev.syncended.kube.htmx.utils.hxDelete
import dev.syncended.kube.htmx.utils.hxGet
import dev.syncended.kube.htmx.utils.hxIndicator
import dev.syncended.kube.htmx.utils.hxPost
import dev.syncended.kube.htmx.utils.hxPut
import dev.syncended.kube.htmx.utils.hxSwap
import dev.syncended.kube.htmx.utils.hxTarget
import dev.syncended.kube.htmx.utils.hxTrigger
import kotlinx.html.CommonAttributeGroupFacade

object HtmxModifierAttributesPlugin : KubePlugin.ModifierAttributes {
  override fun apply(modifier: Modifier, tag: CommonAttributeGroupFacade) {
    modifier.hxGet?.let { tag.hxGet = it }
    modifier.hxPost?.let { tag.hxPost = it }
    modifier.hxPut?.let { tag.hxPut = it }
    modifier.hxDelete?.let { tag.hxDelete = it }
    modifier.hxTarget?.let { tag.hxTarget = it }
    modifier.hxIndicator?.let { tag.hxIndicator = it }
    modifier.hxSwap?.let { tag.hxSwap = it }
    modifier.hxTrigger?.let { tag.hxTrigger = it }
  }
}