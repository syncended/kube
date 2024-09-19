@file:Suppress("UNCHECKED_CAST")

package dev.syncended.kube.core.component

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Color
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.core.model.Size
import dev.syncended.kube.styling.Selectors.dynamicDesktop
import dev.syncended.kube.styling.Selectors.dynamicMobile
import dev.syncended.kube.styling.Size.percent100
import dev.syncended.kube.core.component.Modifier as CoreModifier

open class Modifier private constructor(
  private val properties: Map<String, Any>
) {

  fun <T> get(key: String): T? = properties[key] as? T
  fun set(key: String, value: Any?): CoreModifier {
    val newProps = properties.toMutableMap()
    if (value != null) {
      newProps[key] = value
    } else {
      newProps.remove(key)
    }
    return CoreModifier(newProps)
  }

  companion object Modifier : CoreModifier(emptyMap())
}

internal val Modifier.id: Selector.Id? get() = get("id")
internal val Modifier.classes: List<Selector.Class> get() = get("classes") ?: emptyList()

fun Modifier.id(value: Selector.Id?): Modifier = set("id", value)
fun Modifier.withClass(value: Selector.Class) = set("classes", classes + value)

internal val Modifier.backgroundColor: Color? get() = get("backgroundColor")
fun Modifier.backgroundColor(value: Color?) = set("backgroundColor", value)

internal val Modifier.width: Size? get() = get("width")
internal val Modifier.minWidth: Size? get() = get("minWidth")
internal val Modifier.maxWidth: Size? get() = get("maxWidth")
fun Modifier.width(value: Size?) = set("width", value)
fun Modifier.minWidth(value: Size?) = set("minWidth", value)
fun Modifier.maxWidth(value: Size?) = set("maxWidth", value)

internal val Modifier.height: Size? get() = get("height")
internal val Modifier.minHeight: Size? get() = get("minHeight")
internal val Modifier.maxHeight: Size? get() = get("maxHeight")
fun Modifier.height(value: Size?) = set("height", value)
fun Modifier.minHeight(value: Size?) = set("minHeight", value)
fun Modifier.maxHeight(value: Size?) = set("maxHeight", value)

fun Modifier.fillMaxWidth() = width(percent100)
fun Modifier.fillMaxHeight() = height(percent100)
fun Modifier.fillMaxSize() = fillMaxWidth().fillMaxHeight()
fun Modifier.size(value: Size) = width(value).height(value)
fun Modifier.size(width: Size, height: Size) = width(width).height(height)
fun Modifier.minSize(width: Size, height: Size) = minWidth(width).minHeight(height)
fun Modifier.maxSize(width: Size, height: Size) = maxWidth(width).maxHeight(height)

internal val Modifier.paddingLeft: Size? get() = get("paddingLeft")
internal val Modifier.paddingRight: Size? get() = get("paddingRight")
internal val Modifier.paddingTop: Size? get() = get("paddingTop")
internal val Modifier.paddingBottom: Size? get() = get("paddingBottom")
fun Modifier.paddingLeft(value: Size?) = set("paddingLeft", value)
fun Modifier.paddingRight(value: Size?) = set("paddingRight", value)
fun Modifier.paddingTop(value: Size?) = set("paddingTop", value)
fun Modifier.paddingBottom(value: Size?) = set("paddingBottom", value)
fun Modifier.paddingHorizontal(value: Size) = padding(left = value, right = value)
fun Modifier.paddingVertical(value: Size) = padding(top = value, bottom = value)
fun Modifier.padding(value: Size) = padding(value, value, value, value)
fun Modifier.padding(
  top: Size? = null,
  left: Size? = null,
  right: Size? = null,
  bottom: Size? = null
): Modifier {
  var result = this
  top?.let { result = result.paddingTop(it) }
  left?.let { result = result.paddingLeft(it) }
  right?.let { result = result.paddingRight(it) }
  bottom?.let { result = result.paddingBottom(it) }
  return result
}

internal val Modifier.marginLeft: Size? get() = get("marginLeft")
internal val Modifier.marginRight: Size? get() = get("marginRight")
internal val Modifier.marginTop: Size? get() = get("marginTop")
internal val Modifier.marginBottom: Size? get() = get("marginBottom")
fun Modifier.marginLeft(value: Size?) = set("marginLeft", value)
fun Modifier.marginRight(value: Size?) = set("marginRight", value)
fun Modifier.marginTop(value: Size?) = set("marginTop", value)
fun Modifier.marginBottom(value: Size?) = set("marginBottom", value)
fun Modifier.marginHorizontal(value: Size) = margin(left = value, right = value)
fun Modifier.marginVertical(value: Size) = margin(top = value, bottom = value)
fun Modifier.margin(
  top: Size? = null,
  left: Size? = null,
  right: Size? = null,
  bottom: Size? = null
): Modifier {
  var result = this
  top?.let { result = result.marginTop(it) }
  left?.let { result = result.marginLeft(it) }
  right?.let { result = result.marginRight(it) }
  bottom?.let { result = result.marginBottom(it) }
  return result
}

internal val Modifier.borderTopLeftRadius: Size? get() = get("borderTopLeftRadius")
internal val Modifier.borderTopRightRadius: Size? get() = get("borderTopRightRadius")
internal val Modifier.borderBottomLeftRadius: Size? get() = get("borderBottomLeftRadius")
internal val Modifier.borderBottomRightRadius: Size? get() = get("borderBottomRightRadius")
fun Modifier.borderTopLeftRadius(value: Size?) = set("borderTopLeftRadius", value)
fun Modifier.borderTopRightRadius(value: Size?) = set("borderTopRightRadius", value)
fun Modifier.borderBottomLeftRadius(value: Size?) = set("borderBottomLeftRadius", value)
fun Modifier.borderBottomRightRadius(value: Size?) = set("borderBottomRightRadius", value)

fun Modifier.borderRadius(
  topLeft: Size? = null,
  topRight: Size? = null,
  bottomLeft: Size? = null,
  bottomRight: Size? = null
): Modifier {
  var result = this
  topLeft?.let { result = result.borderTopLeftRadius(it) }
  topRight?.let { result = result.borderTopRightRadius(it) }
  bottomLeft?.let { result = result.borderBottomLeftRadius(it) }
  bottomRight?.let { result = result.borderBottomRightRadius(it) }
  return result
}

fun Modifier.renderOn(size: LayoutSize) = size.clazz?.let(::withClass) ?: this

sealed class LayoutSize(internal val clazz: Selector.Class?) {
  data object Mobile : LayoutSize(dynamicMobile)
  data object Desktop : LayoutSize(dynamicDesktop)
  data object All : LayoutSize(null)
}
