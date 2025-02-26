package takee.dev.swagger_springboot;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "Admin API", version = "1.0", description = "API for adminstrator")
)
public class SwaggerConfig {
}
