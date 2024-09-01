package dev.syncended.kube.dsl

import dev.syncended.kube.components.Space
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

fun Layout<*>.space(modifier: Modifier) = widget(Space(modifier))