package com.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.user"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("user")
                        .description("user")
                        .version("1.0")
                        .contact(new Contact("","blog.csdn.net","aaa@gmail.com"))
                        //.license("The Apache License")
                        //.licenseUrl("http://www.baidu.com")
                        .build());
    }
}
