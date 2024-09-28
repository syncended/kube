plugins {
  alias(libs.plugins.kotlin.jvm)
  `java-library`
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(projects.core)

  implementation(libs.kotlin.stdlib)
  implementation(libs.kotlin.html)
}
