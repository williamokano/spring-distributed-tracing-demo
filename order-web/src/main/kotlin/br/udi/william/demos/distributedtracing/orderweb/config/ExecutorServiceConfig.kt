package br.udi.william.demos.distributedtracing.orderweb.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
open class ExecutorServiceConfig {
    @Bean
    open fun executorService(): ExecutorService {
        return Executors.newFixedThreadPool(10)
    }
}
