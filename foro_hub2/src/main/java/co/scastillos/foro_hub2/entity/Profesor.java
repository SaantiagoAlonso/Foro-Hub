package co.scastillos.foro_hub2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Profesor extends Usuario{

//    @EmbeddedId
//    private Long id;

    private String Especialidad;

    @OneToMany(targetEntity = Curso.class,mappedBy = "profesor")
    private List<Curso> cursos;

    public Profesor(){
        super("pedro",34,2);
    }

}
