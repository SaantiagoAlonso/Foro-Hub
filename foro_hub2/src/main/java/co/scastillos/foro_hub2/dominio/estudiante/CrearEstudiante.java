package co.scastillos.foro_hub2.dominio.estudiante;

import jakarta.validation.constraints.NotBlank;

public record CrearEstudiante(@NotBlank String nombre, @NotBlank String clave, Integer edad, @NotBlank String correo) {
}
