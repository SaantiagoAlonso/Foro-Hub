package co.scastillos.foro_hub2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
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
    private List<Respuesta> Misrespuestas;

    public Usuario(String nombre, Integer edad, int opcion) {
        this.nombre = nombre;
        this.edad = edad;
        if (opcion == 1) {
            this.rol = Rol.ESTUDIANTE;
        }else{
            this.rol = Rol.PROFESOR;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
