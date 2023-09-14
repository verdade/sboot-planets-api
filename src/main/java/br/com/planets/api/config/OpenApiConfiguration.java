package br.com.planets.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class OpenApiConfiguration extends ApplicationConfig {

    private static ApiInfo apiInfo() {
        return new ApiInfo(buildProperties().get("name"),
                buildProperties().get("description"),
                buildProperties().get("version"),
                "https://swagger.io/terms/",
                null,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.planets.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
