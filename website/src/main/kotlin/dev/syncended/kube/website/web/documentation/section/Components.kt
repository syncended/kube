package dev.syncended.kube.website.web.documentation.section

import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.component.marginBottom
import dev.syncended.kube.core.component.marginRight
import dev.syncended.kube.core.component.showOn
import dev.syncended.kube.core.component.showOnMobile
import dev.syncended.kube.core.component.width
import dev.syncended.kube.core.component.weight
import dev.syncended.kube.core.model.Breakpoint
import dev.syncended.kube.dsl.column
import dev.syncended.kube.dsl.row
import dev.syncended.kube.dsl.text
import dev.syncended.kube.styling.Size.percent100
import dev.syncended.kube.website.web.components.Sizes.spaceSizeDefault
import dev.syncended.kube.website.web.components.Sizes.spaceSizeSmall
import dev.syncended.kube.website.web.components.cardComponent
import dev.syncended.kube.website.web.components.title

fun Layout.components() {
  title("Responsive components")
  text(
    "Breakpoint helpers: showOn / hideOn work on top of flex layout.",
    modifier = Modifier.marginBottom(spaceSizeDefault)
  )

  row(modifier = Modifier.width(percent100)) {
    cardComponent(modifier = Modifier.weight(1).marginRight(spaceSizeSmall)) {
      column {
        title("Visibility by device", modifier = Modifier.marginBottom(spaceSizeSmall))
        text("Visible only on mobile", modifier = Modifier.showOnMobile())
        text(
          "Visible on tablet/desktop/wide",
          modifier = Modifier.showOn(Breakpoint.Tablet, Breakpoint.Desktop, Breakpoint.Wide)
        )
      }
    }

    cardComponent(modifier = Modifier.weight(1)) {
      column {
        title("Reordering columns", modifier = Modifier.marginBottom(spaceSizeSmall))
        row(modifier = Modifier.width(percent100).marginBottom(spaceSizeSmall)) {
          text("Main content", modifier = Modifier.weight(2))
          text(
            "Sidebar",
            modifier = Modifier.weight(1)
              .showOn(Breakpoint.Desktop, Breakpoint.Wide)
          )
        }
        text(
          "Sidebar hides on mobile/tablet but can be shown below:",
          modifier = Modifier.marginBottom(spaceSizeSmall)
        )
        text(
          "Sidebar (below)",
          modifier = Modifier.showOn(Breakpoint.Mobile, Breakpoint.Tablet)
        )
      }
    }
  }
}
