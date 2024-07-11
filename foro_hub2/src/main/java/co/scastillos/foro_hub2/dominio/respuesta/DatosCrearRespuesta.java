package co.scastillos.foro_hub2.dominio.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCrearRespuesta(
       @NotBlank String mensaje,

       @NotNull Long id_topic,

       @NotNull String autor

) {
}
