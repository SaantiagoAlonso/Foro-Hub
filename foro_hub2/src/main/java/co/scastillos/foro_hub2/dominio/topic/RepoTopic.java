package co.scastillos.foro_hub2.dominio.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoTopic extends JpaRepository<Topic,Long> {
}
