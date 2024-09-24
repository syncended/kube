package dev.syncended.kube.core

import dev.syncended.kube.core.component.Modifier
import kotlinx.css.CssBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.HEAD
import kotlinx.html.Tag

/**
 * Core entity, which allow append core functions of KUBE.
 */
sealed interface KubePlugin {

  /**
   * Plugin for to main.css composition phase.
   * Should be used to add new styling rules of your elements.
   */
  interface Styling : KubePlugin {
    fun apply(cssBuilder: CssBuilder)
  }

  /**
   * Plugin to apply custom modifier params, to element's style attribute
   */
  interface ModifierStyling : KubePlugin {
    fun apply(modifier: Modifier, cssBuilder: CssBuilder)
  }

  /**
   * Plugin to add custom tags, depending on modifier
   */
  interface ModifierAttributes : KubePlugin {
    fun apply(modifier: Modifier, tag: CommonAttributeGroupFacade)
  }

  /**
   * Plugin to add custom elements to html webpage HEAD
   */
  interface HeadAppender : KubePlugin {
    fun apply(head: HEAD)
  }

  /**
   * Plugin to add batch of plugins.
   */
  interface PluginsWrapper : KubePlugin {
    val plugins: Set<KubePlugin>
  }
}