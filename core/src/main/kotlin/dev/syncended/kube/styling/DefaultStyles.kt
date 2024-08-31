package dev.syncended.kube.styling

import dev.syncended.kube.styling.Selectors.all
import dev.syncended.kube.styling.Selectors.body
import dev.syncended.kube.styling.Selectors.html
import dev.syncended.kube.styling.Size.percent100
import dev.syncended.kube.styling.Size.rem0
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.UserSelect
import kotlinx.css.height
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.userSelect

internal fun defaultStyling() {
  all.styling {
    padding = Padding(rem0.toDimension())
    margin = Margin(rem0.toDimension())
    userSelect = UserSelect.none
  }
  html.styling {
    height = percent100.toDimension()
  }
  body.styling {
    height = percent100.toDimension()
  }
}