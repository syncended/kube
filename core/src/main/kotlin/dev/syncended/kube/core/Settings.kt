package dev.syncended.kube.core

import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.styling.Colors
import dev.syncended.kube.styling.Fonts.jbMono
import dev.syncended.kube.styling.Size.rem05
import dev.syncended.kube.styling.Size.rem1

internal data class Settings(
  val resources: Resources = Resources(),
  val fonts: Fonts = Fonts(),
  val styling: Styling = Styling()
)

data class Resources(
  val prefix: String = "",
  val mode: ResourceMode = ResourceMode.FAT,
)

internal data class Fonts(
  val defaultFont: Font? = jbMono,
  val fonts: List<Font> = listOf(jbMono)
)

internal data class Styling(
  val codeBlockBackground: Color = Colors.codeBlockBackground,
  val codeBlockBorderRadius: Size = rem1,
  val codeBlockPadding: Size = rem05
)

class SettingsBuilder internal constructor() {
  var resources: ResourcesBuilder = ResourcesBuilder.newInstance()
  var fonts: FontsBuilder = FontsBuilder.newInstance()
  var styling: StylingBuilder = StylingBuilder.newInstance()

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

  fun styling(builder: StylingBuilder.() -> Unit) {
    styling.builder()
  }

  internal fun build(): Settings {
    return Settings(
      resources = resources.build(),
      fonts = fonts.build(),
      styling = styling.build()
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

class StylingBuilder internal constructor(current: Styling) {
  var codeBlockBackground = current.codeBlockBackground
  var codeBlockBorderRadius = current.codeBlockBorderRadius
  var codeBlockPadding = current.codeBlockPadding

  fun withCodeBlockBackground(color: Color): StylingBuilder {
    this.codeBlockBackground = color
    return this
  }

  fun withCodeBlockBorderRadius(radius: Size): StylingBuilder {
    this.codeBlockBorderRadius = radius
    return this
  }

  fun withCodeBlockPadding(padding: Size): StylingBuilder {
    this.codeBlockPadding = padding
    return this
  }

  internal fun build(): Styling {
    return Styling(
      codeBlockBackground = codeBlockBackground
    )
  }

  companion object {
    @JvmStatic
    fun newInstance(): StylingBuilder = StylingBuilder(Kube.settings.styling)
  }
}
