package builder

import PublishingInfo
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.internal.catalog.DelegatingProjectDependency
import org.gradle.api.plugins.JavaApplication
import org.gradle.api.provider.Provider
import org.gradle.jvm.tasks.Jar
import org.gradle.plugin.use.PluginDependency
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

abstract class ModuleBuilder(
  protected val project: Project,
  private val moduleName: String
) {
  private val pluginBuilder = PluginBuilder(project)
  private val dependencyBuilder = DependencyBuilder(project)

  init {
    plugins { apply("kotlin-jvm") }
    dependencies { implementation("kotlin-stdlib") }
    applyDefaultPlugins()
    applyDefaultDependencies()
    applyArchiveName(moduleName)
  }

  fun plugins(builder: PluginBuilder.() -> Unit) {
    pluginBuilder.builder()
  }

  fun plugins(vararg plugins: Provider<PluginDependency>) = plugins {
    plugins.forEach { apply(it) }
  }

  fun dependencies(builder: DependencyBuilder.() -> Unit) {
    dependencyBuilder.builder()
  }

  fun modules(vararg modules: DelegatingProjectDependency) {
    dependencies { modules.forEach { implementation(it) } }
  }

  fun modulesApi(vararg modules: DelegatingProjectDependency) {
    dependencies { modules.forEach { api(it) } }
  }

  fun implementation(vararg deps: Provider<MinimalExternalModuleDependency>) {
    dependencies { deps.forEach { implementation(it) } }
  }

  fun api(vararg deps: Provider<MinimalExternalModuleDependency>) {
    dependencies { deps.forEach { api(it) } }
  }

  protected open fun applyDefaultPlugins() {

  }

  protected open fun applyDefaultDependencies() {

  }

  private fun applyArchiveName(name: String) {
    val isApplication = this is ApplicationBuilder
    project.tasks.withType(Jar::class.java) {
      archiveBaseName.set(name)
      if (isApplication) {
        doLast {
          val archive = archiveFile.get().asFile
          val serviceFile = File(archive.parentFile, "service.jar")
          Files.copy(
            archive.toPath(),
            serviceFile.toPath(),
            StandardCopyOption.REPLACE_EXISTING
          )
        }
      }
    }
  }
}

class ApplicationBuilder(
  project: Project
) : ModuleBuilder(project, "service") {
  private val requireApplication: JavaApplication
    get() = project.extensions.findByType(JavaApplication::class.java)!!

  var mainClass: String
    get() = requireApplication.mainClass.get()
    set(value) = requireApplication.mainClass.set(value)

  var group: String
    get() = project.group.toString()
    set(value) {
      project.group = value
    }

  var version: String
    get() = project.version.toString()
    set(value) {
      project.version = value
    }

  init {
    version = PublishingInfo.releaseVersion
  }

  override fun applyDefaultPlugins() = plugins {
    apply("application")
  }
}

class LibraryBuilder(project: Project, name: String) : ModuleBuilder(project, name) {
  init {
    project.setupPublishing(name)
    println("Library version: ${PublishingInfo.releaseVersion}")
  }

  override fun applyDefaultPlugins() = plugins {
    apply("java-library")
    apply("signing")
    apply("sonatype-publish")
  }
}
