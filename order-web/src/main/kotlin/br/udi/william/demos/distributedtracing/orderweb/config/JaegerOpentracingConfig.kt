package br.udi.william.demos.distributedtracing.orderweb.config

import io.jaegertracing.Configuration
import io.jaegertracing.samplers.ProbabilisticSampler
import io.opentracing.Scope
import io.opentracing.ScopeManager
import io.opentracing.Span
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
            .tracerBuilder
            .withScopeManager(InheritableThreadLocalScopeManager())
            .build()
    }
}

class InheritableThreadLocalScope(
    private var scopeManager: InheritableThreadLocalScopeManager,
    private var wrapped: Span?,
    private var finishOnClose: Boolean
) : Scope {

    private var toRestore: InheritableThreadLocalScope? = scopeManager.tlsScope.get()

    init {
        scopeManager.tlsScope.set(this)
    }

    override fun close() {
        if (scopeManager.tlsScope.get() == this) {
            if (finishOnClose) {
                wrapped?.finish()
            }

            scopeManager.tlsScope.set(this.toRestore)
        }
    }

    override fun span(): Span? = wrapped

}

class InheritableThreadLocalScopeManager : ScopeManager {

    var tlsScope: InheritableThreadLocal<InheritableThreadLocalScope> = InheritableThreadLocal()

    override fun activate(span: Span?, finishSpanOnClose: Boolean): Scope {
        return InheritableThreadLocalScope(this, span, finishSpanOnClose)
    }

    override fun active(): Scope? {
        return tlsScope.get()
    }

}