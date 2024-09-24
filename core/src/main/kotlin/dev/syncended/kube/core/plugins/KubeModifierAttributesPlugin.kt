package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.id
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.id

object KubeModifierAttributesPlugin: KubePlugin.ModifierAttributes {

  override fun apply(modifier: Modifier, tag: CommonAttributeGroupFacade) {
    modifier.id?.let { tag.id = it.name }
  }
}