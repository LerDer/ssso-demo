package com.sso.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lww
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    private static final String BASE_PACKAGE = "com.sso.demo.controller";

    //@Bean
    //public Docket adminApi() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .groupName("admin")
    //            .apiInfo(apiInfo())
    //            .forCodeGeneration(true)
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE + ".admin"))
    //            .paths(PathSelectors.any())
    //            .build();
    //}
    //
    //@Bean
    //public Docket managerApi() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .groupName("manager")
    //            .apiInfo(apiInfo())
    //            .forCodeGeneration(true)
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE + ".manager"))
    //            .paths(PathSelectors.any())
    //            .build();
    //}
    //
    //@Bean
    //public Docket freelancerApi() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .groupName("freelancer")
    //            .apiInfo(apiInfo())
    //            .forCodeGeneration(true)
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE + ".freelancer"))
    //            .paths(PathSelectors.any())
    //            .build();
    //}
    //
    //@Bean
    //public Docket LoginApi() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .groupName("login")
    //            .apiInfo(apiInfo())
    //            .forCodeGeneration(true)
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE + ".login"))
    //            .paths(PathSelectors.any())
    //            .build();
    //}

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("sso")
                .description("接口文档")
                .version("1.0.1")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    }

}
