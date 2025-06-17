package online.northal.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Lease Web API Documentation")
                        .version("1.0.0")
                        .description("This is the API documentation for the Lease Web application."));
    }

    @Bean
    public GroupedOpenApi systemApi() {
        return GroupedOpenApi
                .builder()
                .group("管理系统")
                .pathsToMatch("/**")
                .build();
    }
}
