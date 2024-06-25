package dev.syncended.kube.playground

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing

fun main() {
  embeddedServer(
    factory = Netty,
    port = 80,
    host = "0.0.0.0",
    module = Application::setup
  ).start(true)
}

private fun Application.setup() {
  installRoutes()
}

private fun Application.installRoutes() = routing {
  helloWorld()
}