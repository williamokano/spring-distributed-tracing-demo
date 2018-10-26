package br.udi.william.demos.distributedtracing.orderweb.application

import br.udi.william.demos.distributedtracing.orderweb.config.OrderWebConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(OrderWebConfig::class)
open class OrderWebApplication

fun main(args: Array<String>) {
    SpringApplication.run(OrderWebApplication::class.java, *args)
}