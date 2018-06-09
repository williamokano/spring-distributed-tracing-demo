package br.udi.william.demos.distributedtracing.commons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "br.udi.william.demos.distributedtracing.commons.commons"
})
public class CommonsConfig {
}
