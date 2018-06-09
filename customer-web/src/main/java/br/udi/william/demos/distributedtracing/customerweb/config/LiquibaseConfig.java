package br.udi.william.demos.distributedtracing.customerweb.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
@AllArgsConstructor
@NoArgsConstructor
public class LiquibaseConfig {
    private DataSource dataSource;
    private LiquibaseProperties liquibaseProperties;

    @Bean
    public SpringLiquibase springLiquibase() {
        SpringLiquibase springLiquibase = new SpringLiquibase();

        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog(liquibaseProperties.getChangeLog());
        springLiquibase.setContexts(liquibaseProperties.getContexts());
        springLiquibase.setLabels(liquibaseProperties.getLabels());
        springLiquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        springLiquibase.setDropFirst(liquibaseProperties.isDropFirst());
        springLiquibase.setShouldRun(liquibaseProperties.isEnabled());

        return springLiquibase;
    }
}
