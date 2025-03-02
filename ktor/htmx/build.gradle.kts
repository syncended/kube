library("kube-ktor-core") {
    modulesApi(
        projects.ktor.core,
        projects.htmx,
    )

    implementation(libs.ktor.server.core)
}
