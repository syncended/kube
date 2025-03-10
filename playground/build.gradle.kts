application {
    modules(
        projects.spring,
        projects.ktor,
    )

    implementation(
        libs.kotlin.stdlib,
        libs.kotlin.reflect,
        libs.kotlin.coroutines.core,
        libs.kotlin.coroutines.reactor,

        libs.spring.boot.webflux,

        libs.ktor.server.core,
        libs.ktor.server.netty,

        libs.slf4j,
        libs.logback,
    )
}
