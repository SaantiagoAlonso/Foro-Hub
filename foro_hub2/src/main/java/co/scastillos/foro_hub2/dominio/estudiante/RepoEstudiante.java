package co.scastillos.foro_hub2.dominio.estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEstudiante extends JpaRepository<Estudiante,Long> {
}
