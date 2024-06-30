package dev.syncended.kube.core.styling

import dev.syncended.kube.core.widget.core.px
import kotlinx.css.CssBuilder
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.background
import kotlinx.css.margin
import kotlinx.css.maxHeight
import kotlinx.css.maxWidth
import kotlinx.css.minHeight
import kotlinx.css.minWidth
import kotlinx.css.padding

fun Modifier.buildStyle(): String {
  val builder = CssBuilder()
  builder.applyPadding(this)
  builder.applyMargin(this)
  builder.applyBackground(this)
  builder.applyMaxSize(this)
  return builder.toString()
}

private fun CssBuilder.applyPadding(modifier: Modifier) {
  val top = modifier.paddingTop ?: modifier.paddingVertical ?: modifier.padding
  val bottom = modifier.paddingBottom ?: modifier.paddingVertical ?: modifier.padding
  val left = modifier.paddingLeft ?: modifier.paddingHorizontal ?: modifier.padding
  val right = modifier.paddingRight ?: modifier.paddingHorizontal ?: modifier.padding

  if (top == null && bottom == null && left == null && right == null) return
  padding = Padding(top = top?.px, bottom = bottom?.px, left = left?.px, right = right?.px)
}

private fun CssBuilder.applyMargin(modifier: Modifier) {
  val top = modifier.marginTop ?: modifier.marginVertical ?: modifier.margin
  val bottom = modifier.marginBottom ?: modifier.marginVertical ?: modifier.margin
  val left = modifier.marginLeft ?: modifier.marginHorizontal ?: modifier.margin
  val right = modifier.marginRight ?: modifier.marginHorizontal ?: modifier.margin

  if (top == null && bottom == null && left == null && right == null) return
  margin = Margin(top = top?.px, bottom = bottom?.px, left = left?.px, right = right?.px)
}

private fun CssBuilder.applyBackground(modifier: Modifier) {
  background = modifier.background ?: return
}

private fun CssBuilder.applyMaxSize(modifier: Modifier) {
  modifier.maxWidth?.let { maxWidth = it.px }
  modifier.maxHeight?.let { maxHeight = it.px }
  modifier.minWidth?.let { minWidth = it.px }
  modifier.minHeight?.let { minHeight = it.px }
}