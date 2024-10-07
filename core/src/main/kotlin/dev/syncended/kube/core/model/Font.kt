package dev.syncended.kube.core.model

import dev.syncended.kube.core.Kube.settings
import kotlinx.css.FontWeight
import loadResource
import trimSlashes
import kotlinx.css.FontStyle as CssFontStyle

data class Font(
  val name: String,
  val resources: List<FontResource>
)

data class FontResource(
  val resourceName: String,
  val size: FontSize,
  val style: FontStyle
)

sealed class FontStyle(internal val mapping: CssFontStyle) {
  data object Normal : FontStyle(CssFontStyle.normal)
  data object Italic : FontStyle(CssFontStyle.italic)
}

sealed class FontSize(internal val mapping: FontWeight) {
  data object Thin : FontSize(FontWeight.w100)
  data object Regular : FontSize(FontWeight.normal)
  data object Medium : FontSize(FontWeight.w300)
  data object Bold : FontSize(FontWeight.bold)
}

val FontResource.name: String
  get() = resourceName.split('/').last()
val FontResource.extension: String
  get() = name.split('.').last()
val FontResource.url: String
  get() = "/${settings.resources.prefix}/font/${name}".trimSlashes()

fun FontResource.getBytes(): ByteArray? = loadResource("/$resourceName")
