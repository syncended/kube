library("kube-spring-core") {
  modulesApi(projects.core)

  implementation(
    libs.spring.web,
    libs.spring.boot.starter,
  )
}
