package dev.syncended.kube.dsl

import dev.syncended.kube.components.Column
import dev.syncended.kube.core.Layout

fun Layout.column(body: Column.() -> Unit) = widget(Column(), body)
