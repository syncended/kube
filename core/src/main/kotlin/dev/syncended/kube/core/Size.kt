package dev.syncended.kube.core

sealed class Size {
  data class Px(val value: Int): Size()
  data class Percent(val value: Int): Size()
}