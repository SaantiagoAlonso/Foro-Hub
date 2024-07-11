package co.scastillos.foro_hub2.infra.seguridad;

import co.scastillos.foro_hub2.dominio.usuario.DatosResUsuario;
import co.scastillos.foro_hub2.dominio.usuario.LoginUsuario;
import co.scastillos.foro_hub2.dominio.usuario.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

    @Autowired
    private RepoUsuario repoUsuario;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repoUsuario.findByNombre(username);
    }

    public DatosResUsuario loginUser(LoginUsuario loginUsuario){
        String nombre = loginUsuario.nombre();
        String clave = loginUsuario.clave();

        Authentication authentication = this.authenticar(nombre,clave);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String newToken = jwtUtils.crearToken(authentication);

        DatosResUsuario authReponse = new DatosResUsuario(nombre ,"user logeado correctamente",newToken,true);
        return authReponse;
    }

    private Authentication authenticar(String nombre, String clave) {
        UserDetails userDetails = this.loadUserByUsername(nombre);
        if(userDetails == null){
            throw new BadCredentialsException("usuario o contraseña incorrecta");
        }
        if(!passwordEncoder.matches(clave,userDetails.getPassword())){
            throw new BadCredentialsException(" contraseña incorrecta");
        }

        return new UsernamePasswordAuthenticationToken(nombre,userDetails.getPassword(),userDetails.getAuthorities());
    }


}
