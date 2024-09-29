package builder

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.internal.catalog.DelegatingProjectDependency
import org.gradle.kotlin.dsl.getByType

class DependencyBuilder(private val project: Project) {
  private val libs get() = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

  fun implementation(provider: Provider<MinimalExternalModuleDependency>) {
    project.dependencies.add(IMPLEMENTATION, provider.resolveDependency())
  }

  fun implementation(dependency: DelegatingProjectDependency) {
    project.dependencies.add(IMPLEMENTATION, dependency.dependencyProject)
  }

  fun implementation(name: String) {
    project.dependencies.add(IMPLEMENTATION, name.resolveDependency())
  }

  fun api(provider: Provider<MinimalExternalModuleDependency>) {
    project.dependencies.add(API, provider.resolveDependency())
  }

  fun api(dependency: DelegatingProjectDependency) {
    project.dependencies.add(API, dependency.dependencyProject)
  }

  private fun Provider<MinimalExternalModuleDependency>.resolveDependency(): String {
    val dependency = this.get()
    return "${dependency.group}:${dependency.name}:${dependency.version}"
  }

  private fun String.resolveDependency(): String {
    val dependency = libs.findLibrary(this).get()
    return dependency.resolveDependency()
  }

  private companion object {
    const val IMPLEMENTATION = "implementation"
    const val API = "api"
  }
}
