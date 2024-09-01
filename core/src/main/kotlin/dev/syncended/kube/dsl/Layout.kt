package dev.syncended.kube.dsl

import dev.syncended.kube.components.Column
import dev.syncended.kube.components.Row
import dev.syncended.kube.core.Layout

fun Layout.column(body: Column.() -> Unit) = widget(Column(), body)

fun Layout.row(body: Row.() -> Unit) = widget(Row(), body)