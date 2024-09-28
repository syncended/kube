package dev.syncended.kube.htmx.model

/**
 * https://htmx.org/docs/#swapping
 */
sealed class HxSwap(internal val value: String) {
  data object InnerHTML : HxSwap("innerHTML")
  data object OuterHTML : HxSwap("outerHTML")
  data object AfterBegin : HxSwap("afterbegin")
  data object BeforeBegin : HxSwap("beforebegin")
  data object BeforeEnd : HxSwap("beforeend")
  data object AfterEnd : HxSwap("afterend")
  data object Delete : HxSwap("delete")
  data object None : HxSwap("none")
}
