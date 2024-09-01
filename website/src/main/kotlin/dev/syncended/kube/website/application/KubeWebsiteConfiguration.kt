package dev.syncended.kube.website.application

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.accept.RequestedContentTypeResolverBuilder
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

@EnableWebFlux
@Configuration
@ComponentScan("dev.syncended.kube.website")
open class KubeWebsiteConfiguration : WebFluxConfigurer {

  override fun configureContentTypeResolver(builder: RequestedContentTypeResolverBuilder) {
    builder.fixedResolver(MediaType.TEXT_HTML)
  }
}