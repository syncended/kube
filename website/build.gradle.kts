application {
  mainClass = "dev.syncended.kube.website.application.KubeWebsiteApplication"
  group = "dev.syncended.kube.website"

  plugins(libs.plugins.spring.boot)

  modules(
    projects.spring.core,
    projects.spring.htmx,
  )

  implementation(
    libs.kotlin.stdlib,
    libs.kotlin.reflect,
    libs.kotlin.coroutines.core,
    libs.kotlin.coroutines.reactor,

    libs.spring.boot.webflux,

    libs.slf4j,
    libs.logback,
  )
}
