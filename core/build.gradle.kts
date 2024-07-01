plugins {
  alias(libs.plugins.kotlin.jvm)
  `java-library`
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.kotlin.stdlib)
  implementation(libs.kotlin.html)
  implementation(libs.kotlin.css)
}
