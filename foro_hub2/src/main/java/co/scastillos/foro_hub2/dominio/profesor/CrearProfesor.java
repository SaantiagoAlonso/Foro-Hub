package co.scastillos.foro_hub2.dominio.profesor;

import jakarta.validation.constraints.NotBlank;

public record CrearProfesor(@NotBlank String nombre,@NotBlank String clave, Integer edad, @NotBlank String correo) {
}
