plugins {
  alias(libs.plugins.kotlin.jvm)
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.kotlin.stdlib)

  implementation(projects.core)

  implementation(libs.ktor.server.core)
  implementation(libs.ktor.server.netty)
}
