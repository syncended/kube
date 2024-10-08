package dev.syncended.kube.core

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.ResourceMode
import kotlinx.css.CssBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.HEAD

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
   * Resource mode plugin, how page should be rendered
   * @property mode resources mode
   * @property prefix resources link prefix
   */

  class Resources(
    val mode: ResourceMode = ResourceMode.FAT,
    prefix: String = ""
  ) : KubePlugin {
    val prefix: String = prefix.trim('/')
  }

  /**
   * Font resource, which will be available from kube dsl
   */
  data class FontResource(
    val font: Font
  ) : KubePlugin

  /**
   * Font, which will be used as default font
   */
  data class DefaultFontResource(
    val font: Font
  ) : KubePlugin

  /**
   * Plugin to add batch of plugins.
   */
  interface PluginsWrapper : KubePlugin {
    val plugins: Set<KubePlugin>
  }
}