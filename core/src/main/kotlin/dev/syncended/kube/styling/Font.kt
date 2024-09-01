package dev.syncended.kube.styling

data class Font(
  val name: String,
  val resources: List<FontResource>
)

data class FontResource(
  val resourceName: String,
  val weight: FontWeight,
  val style: FontStyle
)

enum class FontStyle {
  NORMAL, ITALIC
}

enum class FontWeight {
  THIN, REGULAR, MEDIUM, BOLD
}

