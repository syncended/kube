package dev.syncended.kube.core

/**
 * Render mode, to specify, hot webpage should be rendered
 *
 * @property PAGE regular page, that includes resources via link
 * @property FAT_PAGE page, that includes all resources on it (like css/js/fonts), without
 * any additional endpoints to load resources
 * @property VIEW_ONLY render only html elements, with their classes, but without
 * including any resources on it (like css/js, etc)
 */
enum class RenderMode {
  PAGE,
  FAT_PAGE,
  VIEW_ONLY
}