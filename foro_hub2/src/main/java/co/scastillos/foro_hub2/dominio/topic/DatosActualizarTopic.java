package co.scastillos.foro_hub2.dominio.topic;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopic (

        @NotNull
        Long id,

        String titulo,

        String mensaje


) {
}
