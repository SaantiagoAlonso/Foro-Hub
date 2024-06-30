package co.scastillos.foro_hub2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Estudiante extends Usuario {

    private String semestre;

    @ManyToMany(targetEntity = Curso.class)
    @JoinTable(name = "cursos_estudiante", joinColumns = @JoinColumn(name = "id_estudiante"),inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private List<Curso> cursos;

    public Estudiante(){
        super("juan",34,1);
    }

}
