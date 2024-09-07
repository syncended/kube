package dev.syncended.kube.components

class Link(modifier: LinkModifier) : AbstractText<LinkModifier>(modifier) {
  override fun render() = a {
    +modifier.text.orEmpty()
    modifier.href?.let { href = it }
  }
}

class LinkModifier : TextModifier() {
  var href: String? = null
}

fun LinkModifier.href(value: String): LinkModifier {
  href = value
  return this
}

