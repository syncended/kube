package dev.syncended.kube.core.styling

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.Kube.plugins
import dev.syncended.kube.core.KubePlugin
import dev.syncended.kube.core.KubeStyling
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.FontResource
import dev.syncended.kube.core.model.getBytes
import dev.syncended.kube.core.model.toRawSelector
import dev.syncended.kube.core.model.url
import kotlinx.css.fontFamily
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight
import kotlinx.css.src
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private const val URL_TEMPLATE = "url(%s) format(woff2)"
private const val BASE_64_TEMPLATE = "url(data:font/truetype;charset=utf-8;base64,%s) format('truetype')"

internal fun defaultFonts() {
  KubeStyling.fonts.forEach(::fontStyling)
}

internal fun fontStyling(font: Font) {
  KubeStyling.styling(font.name.toRawSelector()) {
    font.resources.forEach { resource ->
      fontFace {
        src = when (plugins.resources) {
          KubePlugin.Resources.Fat -> readBase64Resource(resource)
          KubePlugin.Resources.Link -> URL_TEMPLATE.format(resource.url)
        }
        fontFamily = font.name
        fontWeight = resource.size.mapping
        fontStyle = resource.style.mapping
      }
    }
  }
}


private fun readBase64Resource(resource: FontResource): String {
  val resourceBytes = resource.getBytes() ?: return ""

  @OptIn(ExperimentalEncodingApi::class)
  val encoded = Base64.encode(resourceBytes)
  return BASE_64_TEMPLATE.format(encoded)
}