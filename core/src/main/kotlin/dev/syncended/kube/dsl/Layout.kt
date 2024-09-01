package dev.syncended.kube.dsl

import dev.syncended.kube.components.Column
import dev.syncended.kube.components.ColumnModifier
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.Layout
import dev.syncended.kube.core.Modifier
import dev.syncended.kube.core.modifier

fun Layout<*>.column(
  modifier: ColumnModifier = modifier(),
  body: Column.() -> Unit
) = widget(Column(modifier), body)

fun Layout<*>.row(
  modifier: Modifier = modifier(),
  body: Row.() -> Unit
) = widget(Row(modifier), body)