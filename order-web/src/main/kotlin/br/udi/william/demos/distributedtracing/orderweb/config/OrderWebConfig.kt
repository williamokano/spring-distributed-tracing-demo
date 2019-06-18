package br.udi.william.demos.distributedtracing.orderweb.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackages = ["br.udi.william.demos.distributedtracing.orderweb.application"])
@EntityScan(basePackages = ["br.udi.william.demos.distributedtracing.orderweb.application"])
@EnableJpaRepositories("br.udi.william.demos.distributedtracing.orderweb.application")
@Import(JaegerOpentracingConfig::class, FeignClientsConfig::class, WebFilterConfig::class, ExecutorServiceConfig::class)
open class OrderWebConfig
