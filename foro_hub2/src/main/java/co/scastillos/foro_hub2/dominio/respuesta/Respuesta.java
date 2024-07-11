package co.scastillos.foro_hub2.dominio.respuesta;

import co.scastillos.foro_hub2.dominio.topic.Topic;
import co.scastillos.foro_hub2.dominio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fecha;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private Usuario autor;

    public Respuesta(DatosCrearRespuesta datosCrearRespuesta, Usuario autor, Topic topic) {
        this.mensaje = datosCrearRespuesta.mensaje();
        this.fecha = LocalDateTime.now();
        this.topic = topic;
        this.autor = autor;
    }
}
