package br.udi.william.demos.distributedtracing.catalogweb.application

import br.udi.william.demos.distributedtracing.catalogweb.config.CatalogWebConfiguration
import org.springframework.boot.SpringApplication

object CatalogWebApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(CatalogWebConfiguration::class.java, *args)
    }
}