package br.udi.william.demos.distributedtracing.orderweb.config

import io.jaegertracing.Configuration
import io.jaegertracing.samplers.ProbabilisticSampler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@org.springframework.context.annotation.Configuration
open class JaegerOpentracingConfig {

    @Bean
    @Primary
    open fun jaegerTracer(): io.opentracing.Tracer {
        val sampler = Configuration.SamplerConfiguration()
        sampler.withType(ProbabilisticSampler.TYPE).withParam(1)

        val reporter = Configuration.ReporterConfiguration()

        return Configuration("order-web")
            .withSampler(sampler)
            .withReporter(reporter)
            .tracer
    }
}
