package dev.syncended.kube.core.model

import dev.syncended.kube.core.Kube
import kotlinx.css.FontWeight
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
  get() = "/${Kube.resourcesPrefix}/font/${name}"

fun FontResource.getBytes(): ByteArray? {
  val url = "/$resourceName".replace("//", "/")
  return Kube::class.java.getResource(url)
    ?.readBytes()
}
