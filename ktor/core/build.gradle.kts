library("kube-ktor-core") {
    modulesApi(projects.core)

    implementation(libs.ktor.server.core)
}
