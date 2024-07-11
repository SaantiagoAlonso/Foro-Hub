package co.scastillos.foro_hub2.dominio.topic;

import co.scastillos.foro_hub2.dominio.respuesta.Respuesta;
import co.scastillos.foro_hub2.dominio.usuario.Usuario;
import co.scastillos.foro_hub2.dominio.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @OneToMany(targetEntity = Respuesta.class,mappedBy = "topic")
    private List<Respuesta> respuestas;

    public Topic(DatosCrearTopic topic,Usuario autor,Curso curso) {
        this.titulo = topic.titulo();
        this.mensaje = topic.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = Status.PUBLICADO;
        this.autor = autor;
        this.curso = curso;
        this.respuestas = new ArrayList<>();
    }
}
