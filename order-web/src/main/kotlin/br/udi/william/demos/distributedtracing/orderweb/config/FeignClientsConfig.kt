package br.udi.william.demos.distributedtracing.orderweb.config

import br.udi.william.demos.distributedtracing.commons.commons.catalog.CatalogAPI
import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerAPI
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.okhttp.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.netflix.feign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class FeignClientsConfig {

    private val client: OkHttpClient by lazy { OkHttpClient() }

    @Value("\${customer.url}")
    private lateinit var customerUrl: String

    @Value("\${catalog.url}")
    private lateinit var catalogUrl: String

    @Bean
    open fun customerApi(): CustomerAPI = client(customerUrl)

    @Bean
    open fun catalogApi(): CatalogAPI = client(catalogUrl)

    private inline fun <reified T> client(url: String) =
        Feign.builder()
            .client(client)
            .contract(SpringMvcContract())
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            .target(T::class.java, url)
}