package dev.syncended.kube.core.styling

class Modifier private constructor(
  private val properties: MutableMap<String, Any>
) {
  fun set(key: String, value: Any?) {
    value?.let { properties[key] = it }
      ?: run { properties.remove(key) }
  }

  fun get(key: String): Any? {
    return properties[key]
  }

  fun without(key: String): Modifier {
    val newProps = properties.toMutableMap()
    newProps.remove(key)
    return Modifier(newProps)
  }

  companion object {
    fun newInstance() = Modifier(mutableMapOf())
  }
}

fun Modifier(): Modifier = Modifier.newInstance()

/** Padding in px */
var Modifier.padding: Size.Px?
  get() = get("padding") as? Size.Px
  set(value) = set("padding", value)

/** Padding in px */
var Modifier.paddingVertical: Size.Px?
  get() = get("padding-vertical") as? Size.Px
  set(value) = set("padding-vertical", value)

/** Padding in px */
var Modifier.paddingHorizontal: Size.Px?
  get() = get("padding-horizontal") as? Size.Px
  set(value) = set("padding-horizontal", value)

/** Padding in px */
var Modifier.paddingTop: Size.Px?
  get() = get("padding-top") as? Size.Px
  set(value) = set("padding-top", value)

/** Padding in px */
var Modifier.paddingBottom: Size.Px?
  get() = get("padding-bottom") as? Size.Px
  set(value) = set("padding-bottom", value)

/** Padding in px */
var Modifier.paddingLeft: Size.Px?
  get() = get("padding-left") as? Size.Px
  set(value) = set("padding-left", value)

/** Padding in px */
var Modifier.paddingRight: Size.Px?
  get() = get("padding-right") as? Size.Px
  set(value) = set("padding-right", value)

/** Common padding in px */
fun Modifier.padding(value: Size.Px): Modifier {
  padding = value
  return this
}

/** Side padding in px */
fun Modifier.padding(vertical: Size.Px? = null, horizontal: Size.Px? = null): Modifier {
  paddingVertical = vertical
  paddingHorizontal = horizontal
  return this
}

/** Side padding in px */
fun Modifier.padding(
  top: Size.Px? = null,
  bottom: Size.Px? = null,
  left: Size.Px? = null,
  right: Size.Px? = null
): Modifier {
  paddingTop = top
  paddingBottom = bottom
  paddingLeft = left
  paddingRight = right
  return this
}

/** Margin in px */
var Modifier.margin: Size.Px?
  get() = get("margin") as? Size.Px
  set(value) = set("margin", value)

/** Margin in px */
var Modifier.marginVertical: Size.Px?
  get() = get("margin-vertical") as? Size.Px
  set(value) = set("margin-vertical", value)

/** Margin in px */
var Modifier.marginHorizontal: Size.Px?
  get() = get("margin-horizontal") as? Size.Px
  set(value) = set("margin-horizontal", value)

/** Margin in px */
var Modifier.marginTop: Size.Px?
  get() = get("margin-top") as? Size.Px
  set(value) = set("margin-top", value)

/** Margin in px */
var Modifier.marginBottom: Size.Px?
  get() = get("margin-bottom") as? Size.Px
  set(value) = set("margin-bottom", value)

/** Margin in px */
var Modifier.marginLeft: Size.Px?
  get() = get("margin-left") as? Size.Px
  set(value) = set("margin-left", value)

/** Margin in px */
var Modifier.marginRight: Size.Px?
  get() = get("margin-right") as? Size.Px
  set(value) = set("margin-right", value)


/** Common margin in px */
fun Modifier.margin(value: Size.Px): Modifier {
  margin = value
  return this
}

/** Side margin in px */
fun Modifier.margin(vertical: Size.Px? = null, horizontal: Size.Px? = null): Modifier {
  marginVertical = vertical
  marginHorizontal = horizontal
  return this
}

/** Side margin in px */
fun Modifier.margin(
  top: Size.Px? = null,
  bottom: Size.Px? = null,
  left: Size.Px? = null,
  right: Size.Px? = null
): Modifier {
  marginTop = top
  marginBottom = bottom
  marginLeft = left
  marginRight = right
  return this
}

/** Background color */
var Modifier.background: String?
  get() = get("background") as? String
  set(value) = set("background", value)

/** Background color */
fun Modifier.background(value: String): Modifier {
  background = value
  return this
}

var Modifier.width: Size?
  get() = get("width") as? Size
  set(value) = set("width", value)

var Modifier.height: Size?
  get() = get("height") as? Size
  set(value) = set("height", value)

fun Modifier.width(value: Size): Modifier {
  width = value
  return this
}

fun Modifier.height(value: Size): Modifier {
  height = value
  return this
}

fun Modifier.size(width: Size? = null, height: Size? = null): Modifier {
  width?.let { this.width = it }
  height?.let { this.height = it }
  return this
}

var Modifier.maxWidth: Size?
  get() = get("max-width") as? Size
  set(value) = set("max-width", value)

var Modifier.maxHeight: Size?
  get() = get("max-height") as? Size
  set(value) = set("max-height", value)

fun Modifier.maxWidth(value: Size): Modifier {
  maxWidth = value
  return this
}

fun Modifier.maxHeight(value: Size): Modifier {
  maxHeight = value
  return this
}

fun Modifier.maxSize(width: Size? = null, height: Size? = null): Modifier {
  width?.let { this.maxWidth = it }
  height?.let { this.maxHeight = it }
  return this
}

var Modifier.minWidth: Size?
  get() = get("min-width") as? Size
  set(value) = set("min-width", value)

var Modifier.minHeight: Size?
  get() = get("min-height") as? Size
  set(value) = set("min-height", value)

fun Modifier.minWidth(value: Size): Modifier {
  minWidth = value
  return this
}

fun Modifier.minHeight(value: Size): Modifier {
  minHeight = value
  return this
}

fun Modifier.minSize(width: Size? = null, height: Size? = null): Modifier {
  width?.let { this.minWidth = it }
  height?.let { this.minHeight = it }
  return this
}

var Modifier.gravity: Gravity?
  get() = get("gravity") as? Gravity
  set(value) = set("gravity", value)

fun Modifier.gravity(gravity: Gravity): Modifier {
  this.gravity = gravity
  return this
}

var Modifier.alignment: Alignment?
  get() = get("alignment") as? Alignment
  set(value) = set("alignment", value)

fun Modifier.alignment(alignment: Alignment): Modifier {
  this.alignment = alignment
  return this
}
