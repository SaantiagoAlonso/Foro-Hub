package co.scastillos.foro_hub2.dominio.usuario;

import jakarta.validation.constraints.NotBlank;

public record LoginUsuario(@NotBlank String nombre, @NotBlank String clave) {
}
