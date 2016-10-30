/**
 * 
 */
package co.id.collega.gw.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	@Bean
	  public Docket swaggerSpringMvcPlugin() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	              .paths(paths())
	              .build()
	              .apiInfo(apiInfo())
	              
	            ;
	  }

	  private ApiInfo apiInfo() {
		return new ApiInfo("Gateway master", "Gateway master", "1.0", null, "edwar.saripudin92@gmail.com", null, null);
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
	    return or(
	        regex("/*.*"));
	}
    
	
}
