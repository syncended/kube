package dev.syncended.kube.core.component

import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.styling.Size.percent100

open class Modifier {
  var id: Selector.Id? = null
  val classes: MutableList<Selector.Class> = mutableListOf()

  var backgroundColor: Color? = null

  var width: Size? = null
  var minWidth: Size? = null
  var maxWidth: Size? = null
  var height: Size? = null
  var minHeight: Size? = null
  var maxHeight: Size? = null

  var paddingLeft: Size? = null
  var paddingRight: Size? = null
  var paddingTop: Size? = null
  var paddingBottom: Size? = null

  var marginLeft: Size? = null
  var marginRight: Size? = null
  var marginTop: Size? = null
  var marginBottom: Size? = null
}

fun <T : Modifier> T.id(value: Selector.Id): T {
  id = value
  return this
}

fun <T : Modifier> T.withClass(className: Selector.Class): T {
  classes.add(className)
  return this
}

fun <T : Modifier> T.width(value: Size): T {
  width = value
  return this
}

fun <T : Modifier> T.fillMaxWidth(): T = width(percent100)

fun <T : Modifier> T.height(value: Size): T {
  height = value
  return this
}

fun <T : Modifier> T.fillMaxHeight(): T = height(percent100)

fun <T : Modifier> T.size(width: Size, height: Size): T = width(width).height(height)


fun <T : Modifier> T.minWidth(value: Size): T {
  minWidth = value
  return this
}

fun <T : Modifier> T.minHeight(value: Size): T {
  minHeight = value
  return this
}

fun <T : Modifier> T.minSize(width: Size, height: Size): T = minWidth(width).minHeight(height)

fun <T : Modifier> T.maxWidth(value: Size): T {
  maxWidth = value
  return this
}

fun <T : Modifier> T.maxHeight(value: Size): T {
  maxHeight = value
  return this
}

fun <T : Modifier> T.maxSize(width: Size, height: Size): T = maxWidth(width).maxHeight(height)

fun <T : Modifier> T.margin(
  top: Size? = null,
  left: Size? = null,
  right: Size? = null,
  bottom: Size? = null
): T {
  top?.let { marginTop = it }
  left?.let { marginLeft = it }
  right?.let { marginRight = it }
  bottom?.let { marginBottom = it }
  return this
}

fun <T : Modifier> T.marginHorizontal(value: Size): T = margin(left = value, right = value)
fun <T : Modifier> T.marginVertical(value: Size): T = margin(top = value, bottom = value)
fun <T : Modifier> T.marginLeft(value: Size): T = margin(left = value)
fun <T : Modifier> T.marginRight(value: Size): T = margin(right = value)
fun <T : Modifier> T.marginTop(value: Size): T = margin(top = value)
fun <T : Modifier> T.marginBottom(value: Size): T = margin(bottom = value)


fun <T : Modifier> T.padding(
  top: Size? = null,
  left: Size? = null,
  right: Size? = null,
  bottom: Size? = null
): T {
  top?.let { paddingTop = it }
  left?.let { paddingLeft = it }
  right?.let { paddingRight = it }
  bottom?.let { paddingBottom = it }
  return this
}

fun <T : Modifier> T.paddingHorizontal(value: Size): T = padding(left = value, right = value)
fun <T : Modifier> T.paddingVertical(value: Size): T = padding(top = value, bottom = value)
fun <T : Modifier> T.paddingLeft(value: Size): T = padding(left = value)
fun <T : Modifier> T.paddingRight(value: Size): T = padding(right = value)
fun <T : Modifier> T.paddingTop(value: Size): T = padding(top = value)
fun <T : Modifier> T.paddingBottom(value: Size): T = padding(bottom = value)

fun <T : Modifier> T.backgorundColor(value: Color): T {
  backgroundColor = value
  return this
}
