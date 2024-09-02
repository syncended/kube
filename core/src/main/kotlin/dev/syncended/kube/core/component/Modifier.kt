package dev.syncended.kube.core.component

import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.styling.Size.percent100

open class Modifier {
  internal var id: Selector.Id? = null
  internal val classes: MutableList<Selector.Class> = mutableListOf()

  internal var backgroundColor: Color? = null

  internal var width: Size? = null
  internal var minWidth: Size? = null
  internal var maxWidth: Size? = null
  internal var height: Size? = null
  internal var minHeight: Size? = null
  internal var maxHeight: Size? = null

  internal var paddingLeft: Size? = null
  internal var paddingRight: Size? = null
  internal var paddingTop: Size? = null
  internal var paddingBottom: Size? = null

  internal var marginLeft: Size? = null
  internal var marginRight: Size? = null
  internal var marginTop: Size? = null
  internal var marginBottom: Size? = null

  internal var borderTopLeftRadius: Size? = null
  internal var borderTopRightRadius: Size? = null
  internal var borderBottomLeftRadius: Size? = null
  internal var borderBottomRightRadius: Size? = null
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

fun <T : Modifier> T.fillMaxSize(): T = fillMaxWidth().fillMaxHeight()

fun <T : Modifier> T.size(width: Size, height: Size): T = width(width).height(height)
fun <T : Modifier> T.size(value: Size): T = width(value).height(value)


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

fun <T : Modifier> T.padding(value: Size): T = padding(value, value, value, value)

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

fun <T : Modifier> T.borderTopLeftRadius(size: Size): T {
  borderTopLeftRadius = size
  return this
}

fun <T : Modifier> T.borderTopRightRadius(size: Size): T {
  borderTopRightRadius = size
  return this
}

fun <T : Modifier> T.borderBottomLeftRadius(size: Size): T {
  borderBottomLeftRadius = size
  return this
}

fun <T : Modifier> T.borderBottomRightRadius(size: Size): T {
  borderBottomRightRadius = size
  return this
}

fun <T : Modifier> T.borderRadius(
  topLeft: Size? = null,
  topRight: Size? = null,
  bottomLeft: Size? = null,
  bottomRight: Size? = null
): T {
  topLeft?.let { borderTopLeftRadius = it }
  topRight?.let { borderTopRightRadius = it }
  bottomLeft?.let { borderBottomLeftRadius = it }
  bottomRight?.let { borderBottomRightRadius = it }
  return this
}
