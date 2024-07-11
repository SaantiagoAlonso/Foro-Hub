package co.scastillos.foro_hub2.dominio.topic;


import co.scastillos.foro_hub2.dominio.respuesta.DatosRespuesta;
import co.scastillos.foro_hub2.dominio.usuario.Rol;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DatosResTopic(

        Long id,
        String titulo,

        String mensaje,

        LocalDateTime fecha,

        Status status,

        String autor,

        String autor_correo,

        Rol aturo_rol,

        Long id_curso,
        String nombre_curso,

       List<DatosRespuesta> respuestas

) {

    public DatosResTopic(Topic topic) {
        this(topic.getId(),topic.getTitulo(),topic.getMensaje()
                ,topic.getFecha(),topic.getStatus(),topic.getAutor().getUsername(),
                topic.getAutor().getCorreo(),topic.getAutor().getRol(),
                topic.getCurso().getId(),topic.getCurso().getNombreCurso(),
                topic.getRespuestas().stream().map(DatosRespuesta::new).collect(Collectors.toList()) );
    }
}
