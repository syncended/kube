package dev.syncended.kube.core.model

/**
 * Render mode, to specify, hot webpage should be rendered
 *
 * @property PAGE regular page, that includes resources, scripts, etc
 * @property VIEW_ONLY render only html elements, with their classes, but without
 * including any resources on it
 */
enum class RenderMode {
  PAGE,
  VIEW_ONLY
}