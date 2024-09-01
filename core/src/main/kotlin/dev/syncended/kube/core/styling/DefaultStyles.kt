package dev.syncended.kube.core.styling

import dev.syncended.kube.core.Kube
import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.ResourceMode
import dev.syncended.kube.core.model.toRawSelector
import dev.syncended.kube.styling.Selectors.all
import dev.syncended.kube.styling.Selectors.body
import dev.syncended.kube.styling.Selectors.html
import dev.syncended.kube.styling.Size.percent100
import dev.syncended.kube.styling.Size.rem0
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.UserSelect
import kotlinx.css.fontFamily
import kotlinx.css.fontStyle
import kotlinx.css.fontWeight
import kotlinx.css.height
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.src
import kotlinx.css.userSelect
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private const val URL_TEMPLATE = "url(%s) format(woff2)"
private const val BASE_64_TEMPLATE = "url(data:font/truetype;charset=utf-8;base64,%s) format('truetype')"

internal fun defaultStyling() {
  all.styling {
    padding = Padding(rem0.toDimension())
    margin = Margin(rem0.toDimension())
    userSelect = UserSelect.none
    fontFamily = KubeStyling.defaultFont.name
  }
  html.styling {
    height = percent100.toDimension()
  }
  body.styling {
    height = percent100.toDimension()
  }
}

internal fun defaultFonts() {
  KubeStyling.fonts.forEach(::fontStyling)
}

internal fun fontStyling(font: Font) {
  KubeStyling.styling(font.name.toRawSelector()) {
    font.resources.forEach { resource ->
      fontFace {
        src = when (Kube.resourceMode) {
          ResourceMode.FAT -> readBase64Resource(resource.resourceName)
          ResourceMode.LINK -> URL_TEMPLATE.format(resource.resourceName)
        }
        fontFamily = font.name
        fontWeight = resource.size.mapping
        fontStyle = resource.style.mapping
      }
    }
  }
}


private fun readBase64Resource(name: String): String {
  val url = if (name.startsWith('/')) name else "/$name"
  val resourceBytes = Kube::class.java.getResource(url)
    ?.readBytes() ?: return ""

  @OptIn(ExperimentalEncodingApi::class)
  val encoded = Base64.encode(resourceBytes)
  return BASE_64_TEMPLATE.format(encoded)
}