package br.udi.william.demos.distributedtracing.catalogweb.config

import io.jaegertracing.Configuration
import io.jaegertracing.samplers.ProbabilisticSampler
import org.springframework.context.annotation.Bean

@org.springframework.context.annotation.Configuration
open class JaegerOpentracingConfig {

    @Bean
    open fun jaegerTracer(): io.opentracing.Tracer {
        val sampler = Configuration.SamplerConfiguration()
        sampler.withType(ProbabilisticSampler.TYPE).withParam(1)

        val reporter = Configuration.ReporterConfiguration()

        return Configuration("catalog-web")
            .withSampler(sampler)
            .withReporter(reporter)
            .tracer
    }
}
