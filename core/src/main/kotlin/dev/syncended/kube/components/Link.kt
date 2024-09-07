package dev.syncended.kube.components

class Link(modifier: LinkModifier) : AbstractText<LinkModifier>(modifier) {
  override fun render() = a {
    +modifier.text.orEmpty()
  }
}

class LinkModifier : TextModifier() {

}

