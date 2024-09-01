package dev.syncended.kube.dsl

import dev.syncended.kube.components.Box
import dev.syncended.kube.components.Column
import dev.syncended.kube.components.ColumnModifier
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.RenderMode

fun Layout<*>.box(body: Box.(Modifier) -> Unit) = widget(
  instance = Box(Modifier()),
  body = body
)

fun box(mode: RenderMode = RenderMode.PAGE, body: Box.(Modifier) -> Unit) = widget(
  mode = mode,
  instance = Box(Modifier()),
  body = body
)

fun Layout<*>.column(body: Column.(modifier: ColumnModifier) -> Unit) = widget(
  instance = Column(ColumnModifier()),
  body = body
)

fun column(mode: RenderMode = RenderMode.PAGE, body: Column.(modifier: ColumnModifier) -> Unit) = widget(
  mode = mode,
  instance = Column(ColumnModifier()),
  body = body
)

fun Layout<*>.row(body: Row.(Modifier) -> Unit) = widget(
  instance = Row(Modifier()),
  body = body
)

fun row(mode: RenderMode = RenderMode.PAGE, body: Row.(Modifier) -> Unit) = widget(
  mode = mode,
  instance = Row(Modifier()),
  body = body
)