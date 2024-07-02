package dev.syncended.kube.core.styling

import kotlinx.css.CssBuilder
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.background
import kotlinx.css.height
import kotlinx.css.margin
import kotlinx.css.maxHeight
import kotlinx.css.maxWidth
import kotlinx.css.minHeight
import kotlinx.css.minWidth
import kotlinx.css.padding
import kotlinx.css.width
import kotlinx.html.FlowContent
import kotlinx.html.div

fun Modifier.buildStyle(): String {
  val builder = CssBuilder()
  builder.applyPadding(this)
  builder.applyMargin(this)
  builder.applyBackground(this)
  builder.applyMaxSize(this)
  return builder.toString()
}

fun Modifier.buildClass(): String {
  return buildString {
    append(gravity?.toClass().orEmpty())
    append(' ')
    append(alignment?.toClass().orEmpty())
  }.trim()
}

private fun CssBuilder.applyPadding(modifier: Modifier) {
  val top = modifier.paddingTop ?: modifier.paddingVertical ?: modifier.padding
  val bottom = modifier.paddingBottom ?: modifier.paddingVertical ?: modifier.padding
  val left = modifier.paddingLeft ?: modifier.paddingHorizontal ?: modifier.padding
  val right = modifier.paddingRight ?: modifier.paddingHorizontal ?: modifier.padding

  if (top == null && bottom == null && left == null && right == null) return
  padding = Padding(
    top = top?.toLinearDimension(),
    bottom = bottom?.toLinearDimension(),
    left = left?.toLinearDimension(),
    right = right?.toLinearDimension()
  )
}

private fun CssBuilder.applyMargin(modifier: Modifier) {
  val top = modifier.marginTop ?: modifier.marginVertical ?: modifier.margin
  val bottom = modifier.marginBottom ?: modifier.marginVertical ?: modifier.margin
  val left = modifier.marginLeft ?: modifier.marginHorizontal ?: modifier.margin
  val right = modifier.marginRight ?: modifier.marginHorizontal ?: modifier.margin

  if (top == null && bottom == null && left == null && right == null) return
  margin = Margin(
    top = top?.toLinearDimension(),
    bottom = bottom?.toLinearDimension(),
    left = left?.toLinearDimension(),
    right = right?.toLinearDimension()
  )
}

private fun CssBuilder.applyBackground(modifier: Modifier) {
  background = modifier.background ?: return
}

private fun CssBuilder.applyMaxSize(modifier: Modifier) {
  modifier.width?.let { width = it.toLinearDimension() }
  modifier.height?.let { height = it.toLinearDimension() }
  modifier.maxWidth?.let { maxWidth = it.toLinearDimension() }
  modifier.maxHeight?.let { maxHeight = it.toLinearDimension() }
  modifier.minWidth?.let { minWidth = it.toLinearDimension() }
  modifier.minHeight?.let { minHeight = it.toLinearDimension() }
}

private fun Gravity.toClass(): String {
  return when (this) {
    Gravity.START -> Design.Class.GRAVITY_START
    Gravity.CENTER -> Design.Class.GRAVITY_CENTER
    Gravity.END -> Design.Class.GRAVITY_END
  }
}


private fun Alignment.toClass(): String {
  return when (this) {
    Alignment.TOP -> Design.Class.ALIGN_TOP
    Alignment.CENTER -> Design.Class.ALIGN_CENTER
    Alignment.BOTTOM -> Design.Class.ALIGN_BOTTOM
  }
}
