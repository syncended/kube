plugins {
  alias(libs.plugins.kotlin.jvm)
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