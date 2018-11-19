/**
 * 
 */
package com.ginger.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: Swagger2配置类
 * @author 姜锋
 * @date 2018年9月23日 下午4:59:03
 * @version V1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
				.build();
	}
	private ApiInfo buildApiInf() {
		return new ApiInfoBuilder().title("Ginger Security API Demo").description("springboot swagger2")
				.termsOfServiceUrl("http://ginger-tr:80/swagger-ui.html")
				.contact(new Contact("醉人未醒", "https://www.justginger.top", "admin@justginger.top")).build();
	}
}
