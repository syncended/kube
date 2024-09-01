package dev.syncended.kube.dsl

import dev.syncended.kube.components.Box
import dev.syncended.kube.components.BoxModifier
import dev.syncended.kube.components.Column
import dev.syncended.kube.components.ColumnModifier
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.RenderMode

fun Layout<*>.box(body: Box.() -> Unit) = widget(
  instance = Box(BoxModifier()),
  body = body
)

fun box(mode: RenderMode = RenderMode.PAGE, body: Box.() -> Unit) = widget(
  mode = mode,
  instance = Box(BoxModifier()),
  body = body
)

fun Layout<*>.column(body: Column.() -> Unit) = widget(
  instance = Column(ColumnModifier()),
  body = body
)

fun column(mode: RenderMode = RenderMode.PAGE, body: Column.() -> Unit) = widget(
  mode = mode,
  instance = Column(ColumnModifier()),
  body = body
)

fun Layout<*>.row(body: Row.() -> Unit) = widget(
  instance = Row(Modifier()),
  body = body
)

fun row(mode: RenderMode = RenderMode.PAGE, body: Row.() -> Unit) = widget(
  mode = mode,
  instance = Row(Modifier()),
  body = body
)