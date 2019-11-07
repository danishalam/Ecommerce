package com.example.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is the main class from where our application starts
 *
 */
@SpringBootApplication
@EnableSwagger2
public class RestControllerApplication {

	/**
	 * This is the main method of spring boot application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestControllerApplication.class, args);
	}
	
	 /**
	  * This method 
	 * @return
	 */
	@Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	            .apis(RequestHandlerSelectors
	                .basePackage("com.example.rest"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndPointsInfo());
	    }
	    private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Online Ecommerce Application")
	            .description("Online ecommerce api")
	            .contact(new Contact("Danish Alam", "danish@hcl.com", "danish@hcl.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	    }
	

}
