package com.conti.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ContinentalEnterpriseAssetManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContinentalEnterpriseAssetManagerApplication.class, args);
	}
}

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())

				.select().apis(RequestHandlerSelectors.basePackage("com.conti.enterprise")).paths(PathSelectors.any())
				.build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CONTINENTAL ASSET MANAGEMENT")
				.description("Continental's Asset Management Standalone Service ")
				.license("CONTINENTAL OPENSOURCE LICENSE").version("1.0").build();
	}
}
