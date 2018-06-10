package br.udi.william.demos.distributedtracing.catalogweb.config

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Import(JaegerOpentracingConfig::class)
@ComponentScan(basePackages = ["br.udi.william.demos.distributedtracing.catalogweb.application"])
@EntityScan(basePackages = ["br.udi.william.demos.distributedtracing.catalogweb.application"])
@EnableJpaRepositories("br.udi.william.demos.distributedtracing.catalogweb.application")
@SpringBootApplication
open class CatalogWebConfiguration {
    @Bean
    open fun modelMapper(): ModelMapper = ModelMapper()
}