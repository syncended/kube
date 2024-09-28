plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  implementation(projects.core)
  api(projects.htmx)

  implementation(libs.spring.web)
  implementation(libs.spring.boot.starter)
}