plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  implementation(projects.core)

  implementation(libs.spring.web)
  implementation(libs.spring.boot.starter)
}