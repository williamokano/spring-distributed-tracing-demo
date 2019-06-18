package br.udi.william.demos.distributedtracing.orderweb.config

import br.udi.william.demos.distributedtracing.orderweb.application.filter.ContextFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class WebFilterConfig {
    @Bean
    open fun registerWebContextFilter(): FilterRegistrationBean {
        return FilterRegistrationBean().apply {
            setName("web-context-filter")
            filter = ContextFilter()
            order = 10
        }
    }
}
