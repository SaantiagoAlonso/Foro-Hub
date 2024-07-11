package co.scastillos.foro_hub2.dominio.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCrearTopic (

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        @NotNull
        String autor,
        @NotNull
        Long id_curso


) {
}
