library("kube-htmx") {
  modulesApi(projects.core)

  implementation(
    libs.kotlin.stdlib,
    libs.kotlin.html,
  )
}
