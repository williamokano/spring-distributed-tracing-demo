package br.udi.william.demos.distributedtracing.catalogweb.application

import br.udi.william.demos.distributedtracing.catalogweb.config.CatalogWebConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(CatalogWebConfiguration::class)
open class CatalogWebApplication

fun main(args: Array<String>) {
    SpringApplication.run(CatalogWebApplication::class.java, *args)
}