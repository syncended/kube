plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.spring.boot) apply false
}

repositories {
  mavenCentral()
}

kotlin {
  jvmToolchain(21)
}

allprojects {
  repositories {
    mavenCentral()
  }
}