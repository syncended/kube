package dev.syncended.kube.dsl

import dev.syncended.kube.components.Markdown
import dev.syncended.kube.core.component.Layout
import dev.syncended.kube.core.component.Modifier

fun Layout.markdown(value: String, modifier: Modifier = Modifier) = widget(
  instance = Markdown(
    markdown = value,
    modifier = modifier,
  )
)

fun Layout.markdown(modifier: Modifier = Modifier, valueEvaluator: () -> String) = widget(
  instance = Markdown(
    markdown = valueEvaluator.invoke(),
    modifier = modifier,
  )
)