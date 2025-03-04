library("kube-ktor") {
    modulesApi(
        projects.core,
        projects.htmx
    )

    implementation(
        libs.ktor.server.core,
        libs.ktor.server.netty
    )
}
