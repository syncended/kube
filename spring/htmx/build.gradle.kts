library("kube-spring-htmx") {
  modulesApi(
    projects.core,
    projects.htmx,
    projects.spring.core,
  )

  implementation(
    libs.spring.web,
    libs.spring.boot.starter,
  )
}
