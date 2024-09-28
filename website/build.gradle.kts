import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.spring.boot)
  application
}

dependencies {
  implementation(projects.spring.core)
  implementation(projects.spring.htmx)

  implementation(libs.kotlin.stdlib)
  implementation(libs.kotlin.reflect)
  implementation(libs.kotlin.coroutines.core)
  implementation(libs.kotlin.coroutines.reactor)

  implementation(libs.spring.boot.webflux)

  implementation(libs.slf4j)
  implementation(libs.logback)
}

application {
  mainClass = "dev.syncended.kube.website.application.KubeWebsiteApplication"
  group = "dev.syncended.kube.website"
  version = "0.1"
}

tasks.withType<BootJar> {
  archiveFileName = "service.jar"
}
