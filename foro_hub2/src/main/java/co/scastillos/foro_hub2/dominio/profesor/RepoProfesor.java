package co.scastillos.foro_hub2.dominio.profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepoProfesor extends JpaRepository<Profesor,Long> {
}
