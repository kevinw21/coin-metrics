package com.sullivankw.CoinMetrics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return getDocketBasics()
                .select()
                .apis(basePackage("com.sullivankw"))
                .build()
                .apiInfo(createApiInfo("Api to retrieve coin info/history", null))
                .groupName("One and Only");
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API to get dem coins!")
                .description("API for managing geckos")
                .version("1.0")
                .build();
    }

    protected Docket getDocketBasics() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false);
    }

    protected ApiInfo createApiInfo(String title, String description) {

        Contact contact = new Contact("TBD name", "TDB URL", "TBD Email");
        return new ApiInfo(
                title,
                description,
                null,
                null,
                contact,
                "API documentation",
                null,
                new ArrayList<>());
    }
}
