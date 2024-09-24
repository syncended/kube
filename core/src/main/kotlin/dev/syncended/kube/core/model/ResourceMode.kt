package dev.syncended.kube.core.model

import dev.syncended.kube.core.model.ResourceMode.FAT
import dev.syncended.kube.core.model.ResourceMode.LINK

/**
 * @property FAT build resources into rendered webpage
 * @property LINK link resources as external endpoints
 */
enum class ResourceMode {
  FAT, LINK
}