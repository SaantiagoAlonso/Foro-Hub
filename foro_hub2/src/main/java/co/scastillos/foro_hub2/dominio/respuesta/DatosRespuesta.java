package co.scastillos.foro_hub2.dominio.respuesta;

import java.time.LocalDateTime;

public record DatosRespuesta(Long id, String mensaje, LocalDateTime fecha, String autor) {
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(),respuesta.getFecha(),respuesta.getAutor().getNombre());
    }
}
