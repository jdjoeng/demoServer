package com.rest.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)	// false로 설정하면, swagger에서 제공해주는 응답코드 ( 200,401,403,404 )에 대한 기본 메시지를 제거
                //.groupName(groupName) // Docket Bean이 한 개일 경우 default이므로 생략가능 / 여러 Docket Bean을 생성했을 경우 groupName이 충돌하지 않아야 함
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rest.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rest API 정보")
                .description("작성한 API를 확인 및 테스트 합니다.")
                .version("1.0")
                .build();
    }
}