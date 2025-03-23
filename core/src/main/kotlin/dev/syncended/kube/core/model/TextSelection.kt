package dev.syncended.kube.core.model

import kotlinx.css.UserSelect

enum class TextSelection {
  NONE,
  TEXT,
  ALL
}

internal fun TextSelection.toUserSelect(): UserSelect = when (this) {
  TextSelection.ALL -> UserSelect.all
  TextSelection.TEXT -> UserSelect.text
  TextSelection.NONE -> UserSelect.none
}