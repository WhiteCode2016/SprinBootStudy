//package com.white.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Swagger2 生成API文档配置
// * 文档地址：http://localhost:8080/swagger-ui.html
// *
// * @author: White
// * @date: 2018/6/4
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2Config {
//    private static final String SWAGGER_TITLE = "Spring Boot中使用Swagger2构建RESTFUL API";
//    private static final String SWAGGER_DESC = "关于该项目的更多配置请参考：https://github.com/WhiteCode2016/SpringBootStudy";
//    private static final String AUTHOR = "white";
//    private static final String URL = "https://github.com/WhiteCode2016";
//    private static final String EMAIL = "liukai20161219@outlook.com";
//    private static final String SWAGGER_VERSION = "1.0";
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(null)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.white.web.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(SWAGGER_TITLE)
//                .description(SWAGGER_DESC)
//                .contact(new Contact(AUTHOR,URL,EMAIL))
//                .version(SWAGGER_VERSION)
//                .build();
//    }
//}
