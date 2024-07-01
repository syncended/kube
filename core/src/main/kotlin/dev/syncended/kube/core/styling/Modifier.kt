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

enum class Gravity {
  START, CENTER, END
}

fun Modifier(): Modifier = Modifier.newInstance()

/** Padding in px */
var Modifier.padding: Int?
  get() = get("padding") as? Int
  set(value) = set("padding", value)

/** Padding in px */
var Modifier.paddingVertical: Int?
  get() = get("padding-vertical") as? Int
  set(value) = set("padding-vertical", value)

/** Padding in px */
var Modifier.paddingHorizontal: Int?
  get() = get("padding-horizontal") as? Int
  set(value) = set("padding-horizontal", value)

/** Padding in px */
var Modifier.paddingTop: Int?
  get() = get("padding-top") as? Int
  set(value) = set("padding-top", value)

/** Padding in px */
var Modifier.paddingBottom: Int?
  get() = get("padding-bottom") as? Int
  set(value) = set("padding-bottom", value)

/** Padding in px */
var Modifier.paddingLeft: Int?
  get() = get("padding-left") as? Int
  set(value) = set("padding-left", value)

/** Padding in px */
var Modifier.paddingRight: Int?
  get() = get("padding-right") as? Int
  set(value) = set("padding-right", value)

/** Common padding in px */
fun Modifier.padding(value: Int): Modifier {
  padding = value
  return this
}

/** Side padding in px */
fun Modifier.padding(vertical: Int? = null, horizontal: Int? = null): Modifier {
  paddingVertical = vertical
  paddingHorizontal = horizontal
  return this
}

/** Side padding in px */
fun Modifier.padding(top: Int? = null, bottom: Int? = null, left: Int? = null, right: Int? = null): Modifier {
  paddingTop = top
  paddingBottom = bottom
  paddingLeft = left
  paddingRight = right
  return this
}

/** Margin in px */
var Modifier.margin: Int?
  get() = get("margin") as? Int
  set(value) = set("margin", value)

/** Margin in px */
var Modifier.marginVertical: Int?
  get() = get("margin-vertical") as? Int
  set(value) = set("margin-vertical", value)

/** Margin in px */
var Modifier.marginHorizontal: Int?
  get() = get("margin-horizontal") as? Int
  set(value) = set("margin-horizontal", value)

/** Margin in px */
var Modifier.marginTop: Int?
  get() = get("margin-top") as? Int
  set(value) = set("margin-top", value)

/** Margin in px */
var Modifier.marginBottom: Int?
  get() = get("margin-bottom") as? Int
  set(value) = set("margin-bottom", value)

/** Margin in px */
var Modifier.marginLeft: Int?
  get() = get("margin-left") as? Int
  set(value) = set("margin-left", value)

/** Margin in px */
var Modifier.marginRight: Int?
  get() = get("margin-right") as? Int
  set(value) = set("margin-right", value)


/** Common margin in px */
fun Modifier.margin(value: Int): Modifier {
  margin = value
  return this
}

/** Side margin in px */
fun Modifier.margin(vertical: Int? = null, horizontal: Int? = null): Modifier {
  marginVertical = vertical
  marginHorizontal = horizontal
  return this
}

/** Side margin in px */
fun Modifier.margin(top: Int? = null, bottom: Int? = null, left: Int? = null, right: Int? = null): Modifier {
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

var Modifier.width: Int?
  get() = get("width") as? Int
  set(value) = set("width", value)

var Modifier.height: Int?
  get() = get("height") as? Int
  set(value) = set("height", value)

fun Modifier.width(value: Int): Modifier {
  width = value
  return this
}

fun Modifier.height(value: Int): Modifier {
  height = value
  return this
}

fun Modifier.size(width: Int? = null, height: Int? = null): Modifier {
  width?.let { this.width = it }
  height?.let { this.height = it }
  return this
}

var Modifier.maxWidth: Int?
  get() = get("max-width") as? Int
  set(value) = set("max-width", value)

var Modifier.maxHeight: Int?
  get() = get("max-height") as? Int
  set(value) = set("max-height", value)

fun Modifier.maxWidth(value: Int): Modifier {
  maxWidth = value
  return this
}

fun Modifier.maxHeight(value: Int): Modifier {
  maxHeight = value
  return this
}

fun Modifier.maxSize(width: Int? = null, height: Int? = null): Modifier {
  width?.let { this.maxWidth = it }
  height?.let { this.maxHeight = it }
  return this
}

var Modifier.minWidth: Int?
  get() = get("min-width") as? Int
  set(value) = set("min-width", value)

var Modifier.minHeight: Int?
  get() = get("min-height") as? Int
  set(value) = set("min-height", value)

fun Modifier.minWidth(value: Int): Modifier {
  minWidth = value
  return this
}

fun Modifier.minHeight(value: Int): Modifier {
  minHeight = value
  return this
}

fun Modifier.minSize(width: Int? = null, height: Int? = null): Modifier {
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
