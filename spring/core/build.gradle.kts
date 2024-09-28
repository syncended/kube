plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  api(projects.core)

  implementation(libs.spring.web)
  implementation(libs.spring.boot.starter)
}