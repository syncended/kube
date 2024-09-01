package dev.syncended.kube.styling

import dev.syncended.kube.core.model.Font
import dev.syncended.kube.core.model.FontResource
import dev.syncended.kube.core.model.FontSize
import dev.syncended.kube.core.model.FontStyle

object Fonts {
  val jbMono = Font(
    name = "jb-mono",
    resources = listOf(
      FontResource(
        resourceName = "fonts/jb-mono-regular.woff2",
        size = FontSize.Regular,
        style = FontStyle.Normal
      ),
      FontResource(
        resourceName = "fonts/jb-mono-regular-italic.woff2",
        size = FontSize.Regular,
        style = FontStyle.Italic
      ),
      FontResource(
        resourceName = "fonts/jb-mono-thin.woff2",
        size = FontSize.Thin,
        style = FontStyle.Normal
      ),
      FontResource(
        resourceName = "fonts/jb-mono-thin-italic.woff2",
        size = FontSize.Thin,
        style = FontStyle.Italic
      ),
      FontResource(
        resourceName = "fonts/jb-mono-medium.woff2",
        size = FontSize.Medium,
        style = FontStyle.Normal
      ),
      FontResource(
        resourceName = "fonts/jb-mono-medium-italic.woff2",
        size = FontSize.Medium,
        style = FontStyle.Italic
      ),
      FontResource(
        resourceName = "fonts/jb-mono-bold.woff2",
        size = FontSize.Bold,
        style = FontStyle.Normal
      ),
      FontResource(
        resourceName = "fonts/jb-mono-bold-italic.woff2",
        size = FontSize.Bold,
        style = FontStyle.Italic
      ),
    )
  )
}