package dev.syncended.kube.core

import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.styling.Fonts.jbMono

internal data class Settings(
  val resources: Resources = Resources(),
  val fonts: Fonts = Fonts()
)

data class Resources(
  val prefix: String = "",
  val mode: ResourceMode = ResourceMode.FAT,
)

internal data class Fonts(
  val defaultFont: Font? = jbMono,
  val fonts: List<Font> = listOf(jbMono)
)

class SettingsBuilder internal constructor() {
  var resources: ResourcesBuilder = ResourcesBuilder.newInstance()
  var fonts: FontsBuilder = FontsBuilder.newInstance()

  fun withResources(builder: ResourcesBuilder): SettingsBuilder {
    resources = builder
    return this
  }

  fun withFonts(fonts: FontsBuilder): SettingsBuilder {
    this.fonts = fonts
    return this
  }

  fun fonts(builder: FontsBuilder.() -> Unit) {
    fonts.builder()
  }

  fun resources(builder: ResourcesBuilder.() -> Unit) {
    resources.builder()
  }

  internal fun build(): Settings {
    return Settings(
      resources = resources.build(),
      fonts = fonts.build()
    )
  }

  companion object {
    @JvmStatic
    fun newInstance(): SettingsBuilder {
      return SettingsBuilder()
    }
  }
}

class ResourcesBuilder internal constructor(current: Resources) {
  var prefix: String = current.prefix
  var mode: ResourceMode = current.mode

  fun withMode(mode: ResourceMode): ResourcesBuilder {
    this.mode = mode
    return this
  }

  fun withPrefix(prefix: String): ResourcesBuilder {
    this.prefix = prefix
    return this
  }

  internal fun build(): Resources {
    return Resources(
      prefix = prefix,
      mode = mode
    )
  }

  companion object {
    @JvmStatic
    fun newInstance(): ResourcesBuilder {
      return ResourcesBuilder(Kube.settings.resources)
    }
  }
}

class FontsBuilder internal constructor(current: Fonts) {
  var defaultFont = current.defaultFont
  val fonts = current.fonts.toMutableList()

  fun addFont(font: Font) = withFont(font)

  fun withDefaultFont(font: Font?): FontsBuilder {
    defaultFont = font
    return this
  }

  fun withFont(font: Font): FontsBuilder {
    fonts += font
    return this
  }

  internal fun build(): Fonts {
    return Fonts(
      defaultFont = defaultFont,
      fonts = fonts
    )
  }

  companion object {
    @JvmStatic
    fun newInstance(): FontsBuilder = FontsBuilder(Kube.settings.fonts)
  }
}