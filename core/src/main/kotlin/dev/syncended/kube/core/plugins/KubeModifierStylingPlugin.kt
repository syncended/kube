package dev.syncended.kube.core.plugins

import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.backgroundColor
import dev.syncended.kube.core.component.borderBottomLeftRadius
import dev.syncended.kube.core.component.borderBottomRightRadius
import dev.syncended.kube.core.component.borderTopLeftRadius
import dev.syncended.kube.core.component.borderTopRightRadius
import dev.syncended.kube.core.component.height
import dev.syncended.kube.core.component.marginBottom
import dev.syncended.kube.core.component.marginLeft
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.marginTop
import dev.syncended.kube.core.component.maxHeight
import dev.syncended.kube.core.component.maxWidth
import dev.syncended.kube.core.component.minHeight
import dev.syncended.kube.core.component.minWidth
import dev.syncended.kube.core.component.paddingBottom
import dev.syncended.kube.core.component.paddingLeft
import dev.syncended.kube.core.component.paddingRight
import dev.syncended.kube.core.component.paddingTop
import dev.syncended.kube.core.component.width
import dev.syncended.kube.core.model.toCssColor
import kotlinx.css.CssBuilder
import kotlinx.css.backgroundColor
import kotlinx.css.borderBottomLeftRadius
import kotlinx.css.borderBottomRightRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.height
import kotlinx.css.marginBottom
import kotlinx.css.marginLeft
import kotlinx.css.marginRight
import kotlinx.css.marginTop
import kotlinx.css.maxHeight
import kotlinx.css.maxWidth
import kotlinx.css.minHeight
import kotlinx.css.minWidth
import kotlinx.css.paddingBottom
import kotlinx.css.paddingLeft
import kotlinx.css.paddingRight
import kotlinx.css.paddingTop
import kotlinx.css.width

object KubeModifierStylingPlugin: KubePlugin.ModifierStyling {
  override fun apply(modifier: Modifier, cssBuilder: CssBuilder) {
    modifier.width?.let { cssBuilder.width = it.toDimension() }
    modifier.minWidth?.let { cssBuilder.minWidth = it.toDimension() }
    modifier.maxWidth?.let { cssBuilder.maxWidth = it.toDimension() }

    modifier.height?.let { cssBuilder.height = it.toDimension() }
    modifier.minHeight?.let { cssBuilder.minHeight = it.toDimension() }
    modifier.maxHeight?.let { cssBuilder.maxHeight = it.toDimension() }

    modifier.paddingTop?.let { cssBuilder.paddingTop = it.toDimension() }
    modifier.paddingLeft?.let { cssBuilder.paddingLeft = it.toDimension() }
    modifier.paddingRight?.let { cssBuilder.paddingRight = it.toDimension() }
    modifier.paddingBottom?.let { cssBuilder.paddingBottom = it.toDimension() }

    modifier.marginTop?.let { cssBuilder.marginTop = it.toDimension() }
    modifier.marginLeft?.let { cssBuilder.marginLeft = it.toDimension() }
    modifier.marginRight?.let { cssBuilder.marginRight = it.toDimension() }
    modifier.marginBottom?.let { cssBuilder.marginBottom = it.toDimension() }

    modifier.backgroundColor?.let { cssBuilder.backgroundColor = it.toCssColor() }
    modifier.borderTopLeftRadius?.let { cssBuilder.borderTopLeftRadius = it.toDimension() }
    modifier.borderTopRightRadius?.let { cssBuilder.borderTopRightRadius = it.toDimension() }
    modifier.borderBottomLeftRadius?.let { cssBuilder.borderBottomLeftRadius = it.toDimension() }
    modifier.borderBottomRightRadius?.let { cssBuilder.borderBottomRightRadius = it.toDimension() }
  }
}