package br.udi.william.demos.distributedtracing.customerweb.application;

import br.udi.william.demos.distributedtracing.customerweb.config.CustomerWebConfig;
import org.springframework.boot.SpringApplication;

public class CustomerWebApplication {
    public static void main(String... args) {
        SpringApplication.run(CustomerWebConfig.class, args);
    }
}
