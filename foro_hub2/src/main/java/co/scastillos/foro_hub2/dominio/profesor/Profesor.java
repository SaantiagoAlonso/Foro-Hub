package co.scastillos.foro_hub2.dominio.profesor;

import co.scastillos.foro_hub2.dominio.curso.Curso;
import co.scastillos.foro_hub2.dominio.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Profesor extends Usuario {

    @OneToMany(targetEntity = Curso.class,mappedBy = "profesor")
    private List<Curso> cursos;

    public Profesor(CrearProfesor profesor){
        super(profesor.nombre(), profesor.clave(), profesor.correo(), profesor.edad(), 2);
    }


}
