package co.scastillos.foro_hub2.dominio.curso;


import co.scastillos.foro_hub2.dominio.estudiante.Estudiante;
import co.scastillos.foro_hub2.dominio.profesor.Profesor;
import co.scastillos.foro_hub2.dominio.topic.Topic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cruso")
    private String nombreCurso;

    private String descripcion;

    @ManyToOne
    private Profesor profesor;

    @ManyToMany
    @JoinTable(name = "cursos_estudiante", joinColumns = @JoinColumn(name = "id_estudiante"),inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private List<Estudiante> estudiantes;

    @OneToMany(targetEntity = Topic.class,mappedBy = "curso")
    private List<Topic> topicsCurso;

}