import builder.ApplicationBuilder
import builder.LibraryBuilder
import org.gradle.api.Project

fun Project.library(namespace: String, builder: LibraryBuilder.() -> Unit) {
  LibraryBuilder(this, namespace).apply(builder)
}

fun Project.application(builder: ApplicationBuilder.() -> Unit) {
  ApplicationBuilder(this).apply(builder)
}