package co.scastillos.foro_hub2.infra.springDoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
       info = @Info(title = "Foro-Hub",
               description = "Challange alura foro permite publicar y responder dudas a los usuarios de un curso",
               contact = @Contact(
                       name = "Santiago Castillo",
                       email = "castillosantiago442@gmail.com"
               )
       ),

        security = @SecurityRequirement(name = "Seguridad Token")
)
@SecurityScheme(
 name = "Seguridad Token",
 description = "acceso token para api",
 type = SecuritySchemeType.HTTP,
 paramName = HttpHeaders.AUTHORIZATION,
 in = SecuritySchemeIn.HEADER,
 scheme = "bearer",
 bearerFormat = "JWT"
)
public class SpringDocConfiguration {

//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .components(new Components()
//                        .addSecuritySchemes("bearer-key",
//                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer").bearerFormat("JWT")));
//    }



}
