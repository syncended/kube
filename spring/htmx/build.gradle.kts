plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  implementation(projects.core)
  implementation(projects.htmx)

  implementation(libs.spring.web)
  implementation(libs.spring.boot.starter)
}