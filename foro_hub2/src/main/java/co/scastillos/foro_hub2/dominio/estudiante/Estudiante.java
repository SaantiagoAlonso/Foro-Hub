package co.scastillos.foro_hub2.dominio.estudiante;

import co.scastillos.foro_hub2.dominio.curso.Curso;
import co.scastillos.foro_hub2.dominio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Estudiante extends Usuario {

    @ManyToMany(targetEntity = Curso.class)
    @JoinTable(name = "cursos_estudiante", joinColumns = @JoinColumn(name = "id_estudiante"),inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private List<Curso> cursos;

    public Estudiante(CrearEstudiante estudiante){
        super(estudiante.nombre(), estudiante.clave(), estudiante.correo(), estudiante.edad(), 1);
    }

}
