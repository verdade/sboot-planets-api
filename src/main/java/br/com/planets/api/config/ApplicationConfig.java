package br.com.planets.api.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ApplicationConfig {

    @Bean
    @ConditionalOnMissingBean(BuildProperties.class)
    public static BuildProperties buildProperties() {
        var properties = new Properties();
        properties.put("group", "br.com.planets");
        properties.put("artifact", "audit");
        properties.put("description", "Documentação da API da abstração do serviço Planets API");
        properties.put("name", "planets-api");
        properties.put("version", "1.0.0");
        return new BuildProperties(properties);
    }
}
