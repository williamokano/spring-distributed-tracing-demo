package br.udi.william.demos.distributedtracing.customerweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.udi.william.demos.distributedtracing.customerweb.application")
@ComponentScan(basePackages = {
        "br.udi.william.demos.distributedtracing.customerweb.application"
})
@EntityScan(basePackages = {
        "br.udi.william.demos.distributedtracing.customerweb.application"
})
@Import({JaegerOpentracingConfig.class})
public class CustomerWebConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
