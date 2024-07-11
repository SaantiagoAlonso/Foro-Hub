package co.scastillos.foro_hub2.dominio.usuario;

import co.scastillos.foro_hub2.dominio.respuesta.Respuesta;
import co.scastillos.foro_hub2.dominio.topic.Topic;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String clave;

    private Integer edad;

    private String correo;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(targetEntity = Topic.class,mappedBy = "autor")
    private List<Topic> topicList;

    @OneToMany(targetEntity = Respuesta.class,mappedBy = "autor")
    private List<Respuesta> respuestas;

    public Usuario(String nombre,String clave,String correo, Integer edad, int opcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.clave = clave;
        this.correo = correo;
        if (opcion == 1) {
            this.rol = Rol.ESTUDIANTE;
        }else{
            this.rol = Rol.PROFESOR;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of((GrantedAuthority) () -> rol.name()).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return nombre;
    }
}
