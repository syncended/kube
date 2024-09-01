plugins {
  alias(libs.plugins.kotlin.jvm)
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(projects.core)

  implementation(libs.kotlin.stdlib)
  implementation(libs.kotlin.reflect)
  implementation(libs.kotlin.coroutines.core)
  implementation(libs.kotlin.coroutines.reactor)

  implementation(libs.spring.boot.webflux)

  implementation(libs.slf4j)
  implementation(libs.logback)
}
