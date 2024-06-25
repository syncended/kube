plugins {
  alias(libs.plugins.kotlin.jvm)
  `java-library`
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.kotlin.stdlib)
  api(libs.kotlin.html)
  api(libs.kotlin.css)
}
