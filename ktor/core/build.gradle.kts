library("kube-ktor-core") {
    modulesApi(projects.core)

    implementation(
        libs.ktor.server.core,
        libs.ktor.server.netty
    )
}
