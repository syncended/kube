package dev.syncended.kube.dsl

import dev.syncended.kube.components.layout.Box
import dev.syncended.kube.components.layout.Card
import dev.syncended.kube.components.layout.Column
import dev.syncended.kube.components.layout.FlatLayout
import dev.syncended.kube.components.layout.Form
import dev.syncended.kube.components.layout.FormEncoding
import dev.syncended.kube.components.layout.FormMethod
import dev.syncended.kube.components.layout.Link
import dev.syncended.kube.components.layout.Row
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Alignment
import dev.syncended.kube.core.model.RenderMode

fun render(
  mode: RenderMode = RenderMode.PAGE,
  body: FlatLayout.() -> Unit
) = widget(
  mode = mode,
  instance = FlatLayout(),
  body = body
)

fun Layout.box(
  modifier: Modifier = Modifier,
  verticalAlignment: Alignment.Vertical? = null,
  horizontalAlignment: Alignment.Horizontal? = null,
  body: Box.() -> Unit = {}
) = widget(
  instance = Box(
    modifier = modifier,
    verticalAlignment = verticalAlignment,
    horizontalAlignment = horizontalAlignment
  ),
  body = body
)

fun Layout.column(
  modifier: Modifier = Modifier,
  alignment: Alignment.Horizontal? = null,
  body: Column.() -> Unit
) = widget(
  instance = Column(
    modifier = modifier,
    alignment = alignment
  ),
  body = body
)

fun Layout.row(
  modifier: Modifier = Modifier,
  alignment: Alignment.Vertical? = null,
  body: Row.() -> Unit
) = widget(
  instance = Row(
    modifier = modifier,
    alignment = alignment
  ),
  body = body
)

fun Layout.card(
  modifier: Modifier = Modifier,
  verticalAlignment: Alignment.Vertical? = null,
  horizontalAlignment: Alignment.Horizontal? = null,
  body: Card.() -> Unit
) = widget(
  instance = Card(
    modifier = modifier,
    verticalAlignment = verticalAlignment,
    horizontalAlignment = horizontalAlignment
  ),
  body = body
)

fun Layout.link(
  href: String,
  modifier: Modifier = Modifier,
  body: Link.() -> Unit
) = widget(
  instance = Link(
    modifier = modifier,
    href = href
  ),
  body = body
)

fun Layout.form(
  modifier: Modifier = Modifier,
  action: String? = null,
  encoding: FormEncoding? = null,
  method: FormMethod? = null,
  body: Form.() -> Unit
) = widget(
  instance = Form(
    modifier = modifier,
    action = action,
    encoding = encoding,
    method = method
  ),
  body = body
)
