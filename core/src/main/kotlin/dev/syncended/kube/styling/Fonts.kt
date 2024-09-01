package dev.syncended.kube.styling

object Fonts {
  val jbMono = Font(
    name = "jb-mono",
    resources = listOf(
      FontResource(
        resourceName = "fonts/jb-mono-regular.woff2",
        weight = FontWeight.REGULAR,
        style = FontStyle.NORMAL
      ),
      FontResource(
        resourceName = "fonts/jb-mono-regular-italic.woff2",
        weight = FontWeight.REGULAR,
        style = FontStyle.ITALIC
      ),
      FontResource(
        resourceName = "fonts/jb-mono-thin.woff2",
        weight = FontWeight.THIN,
        style = FontStyle.NORMAL
      ),
      FontResource(
        resourceName = "fonts/jb-mono-thin-italic.woff2",
        weight = FontWeight.THIN,
        style = FontStyle.ITALIC
      ),
      FontResource(
        resourceName = "fonts/jb-mono-medium.woff2",
        weight = FontWeight.MEDIUM,
        style = FontStyle.NORMAL
      ),
      FontResource(
        resourceName = "fonts/jb-mono-medium-italic.woff2",
        weight = FontWeight.MEDIUM,
        style = FontStyle.ITALIC
      ),
      FontResource(
        resourceName = "fonts/jb-mono-bold.woff2",
        weight = FontWeight.BOLD,
        style = FontStyle.NORMAL
      ),
      FontResource(
        resourceName = "fonts/jb-mono-bold-italic.woff2",
        weight = FontWeight.BOLD,
        style = FontStyle.ITALIC
      ),
    )
  )
}