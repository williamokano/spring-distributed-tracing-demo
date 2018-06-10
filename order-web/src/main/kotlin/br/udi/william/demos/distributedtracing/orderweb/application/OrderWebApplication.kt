package br.udi.william.demos.distributedtracing.orderweb.application

import br.udi.william.demos.distributedtracing.orderweb.config.OrderWebConfig
import org.springframework.boot.SpringApplication

object OrderWebApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(OrderWebConfig::class.java, *args)
    }
}