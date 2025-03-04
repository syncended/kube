library("kube-spring") {
    modulesApi(
        projects.core,
        projects.htmx
    )

    implementation(
        libs.spring.web,
        libs.spring.boot.starter,
    )
}
