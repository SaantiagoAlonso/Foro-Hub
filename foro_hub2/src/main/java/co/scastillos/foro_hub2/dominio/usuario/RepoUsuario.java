package co.scastillos.foro_hub2.dominio.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario,Long> {
    Usuario findByNombre(String autor);


}
