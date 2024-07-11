package co.scastillos.foro_hub2.dominio.respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRespuesta extends JpaRepository<Respuesta,Long>  {
}
