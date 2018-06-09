package br.udi.william.demos.distributedtracing.customerweb.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {
        "br.udi.william.demos.distributedtracing.customerweb.application"
})
public class CustomerWebConfig {
}
