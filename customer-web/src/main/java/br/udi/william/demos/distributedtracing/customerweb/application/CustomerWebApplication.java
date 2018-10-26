package br.udi.william.demos.distributedtracing.customerweb.application;

import br.udi.william.demos.distributedtracing.customerweb.config.CustomerWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CustomerWebConfig.class)
public class CustomerWebApplication {
    public static void main(String... args) {
        SpringApplication.run(CustomerWebApplication.class, args);
    }
}
