package br.udi.william.demos.distributedtracing.customerweb.config;

import io.jaegertracing.Configuration;
import io.jaegertracing.samplers.ProbabilisticSampler;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JaegerOpentracingConfig {

    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        Configuration.SamplerConfiguration sampler = new Configuration.SamplerConfiguration();
        sampler.withType(ProbabilisticSampler.TYPE).withParam(1);

        Configuration.ReporterConfiguration reporter = new Configuration.ReporterConfiguration();

        return new Configuration("customer-web")
                .withSampler(sampler)
                .withReporter(reporter)
                .getTracer();
    }
}
