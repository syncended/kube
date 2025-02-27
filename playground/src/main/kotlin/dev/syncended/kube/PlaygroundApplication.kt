package dev.syncended.kube

import dev.syncended.kube.dsl.render
import dev.syncended.kube.ktor.core.respondRender
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class PlaygroundApplication : ApplicationRunner {

  override fun run(args: ApplicationArguments?) {
    embeddedServer(
      Netty,
      port = 3001
    ) {
      routing { get("/") { call.respondRender { renderUi() } } }
    }.start(wait = false)
  }

  companion object {
    @JvmStatic
    fun main(vararg args: String) {
      SpringApplication.run(PlaygroundApplication::class.java, *args)
    }
  }
}

@RestController
class SpringRouter {
  @GetMapping("/")
  fun get() = render { renderUi() }
}