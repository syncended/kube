package builder

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

class PluginBuilder(private val project: Project) {
  private val libs get() = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

  fun apply(name: String) {
    project.plugins.apply(name.resolvePlugin())
  }

  fun apply(plugin: Provider<PluginDependency>) {
    project.plugins.apply(plugin.get().pluginId)
  }

  private fun String.resolvePlugin(): String {
    return libs.findPlugin(this).get().get().pluginId
  }
}
