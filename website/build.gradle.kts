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
  implementation(libs.spring.boot.webflux)
  implementation(libs.slf4j)
}
