import org.gradle.jvm.tasks.Jar

plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  implementation(projects.core)
  api(projects.htmx)

  implementation(libs.spring.web)
  implementation(libs.spring.boot.starter)
}

tasks.withType<Jar> {
  archiveBaseName.set("kube-spring-htmx.jar")
}