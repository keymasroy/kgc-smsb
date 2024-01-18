package kr.co.kgc.smsb.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SmsbApiSwaggerConfig {
	
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
						.useDefaultResponseMessages(false)
						.select()
						.apis(RequestHandlerSelectors.basePackage("kr.co.kgc.smsb"))
						.paths(PathSelectors.ant("/api/**"))
						.build()
						.apiInfo(swaggerInfo());
		
	}
	private ApiInfo swaggerInfo() {
		return new ApiInfoBuilder()
					.title("KGC SMSB API Swagger")
					.description("KGC API 시스템 API")
					.license("Apache License Version 2.0")
					.version("1.0.0")
					.build();
	}
}
