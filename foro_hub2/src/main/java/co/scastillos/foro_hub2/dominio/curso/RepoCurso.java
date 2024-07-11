package co.scastillos.foro_hub2.dominio.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepoCurso extends JpaRepository<Curso,Long> {
}
