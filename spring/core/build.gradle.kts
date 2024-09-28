import org.gradle.jvm.tasks.Jar

plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  api(projects.core)

  implementation(libs.spring.web)
  implementation(libs.spring.boot.starter)
}

tasks.withType<Jar> {
  archiveBaseName.set("kube-spring-core.jar")
}