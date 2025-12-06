package dev.syncended.kube.core.model

/**
 * Predefined layout breakpoints for responsive rendering.
 *
 * @property min inclusive min width in px, or `null` if no lower bound
 * @property max inclusive max width in px, or `null` if no upper bound
 */
enum class Breakpoint(
  val min: Int?,
  val max: Int?,
) {
  Mobile(min = null, max = 767),
  Tablet(min = 768, max = 1023),
  Desktop(min = 1024, max = 1439),
  Wide(min = 1440, max = null);

  internal fun mediaQuery(): String = when {
    min != null && max != null -> "screen and (min-width: ${min}px) and (max-width: ${max}px)"
    min != null -> "screen and (min-width: ${min}px)"
    max != null -> "screen and (max-width: ${max}px)"
    else -> "screen"
  }
}
