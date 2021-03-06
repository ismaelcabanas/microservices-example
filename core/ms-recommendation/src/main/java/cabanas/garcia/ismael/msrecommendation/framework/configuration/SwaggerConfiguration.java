package cabanas.garcia.ismael.msrecommendation.framework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ms-recommendation")
                .select()
                .apis(basePackage("cabanas.garcia.ismael.msrecommendation.framework.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Products Recommendation Service")
                .description("Products Recommendation Service")
                .license("Open source licensing")
                .licenseUrl("https://help.github.com/articles/open-source-licensing/")
                .version("1")
                .build();
    }
}
