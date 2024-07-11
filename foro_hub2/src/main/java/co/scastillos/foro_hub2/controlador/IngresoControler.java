package co.scastillos.foro_hub2.controlador;

import co.scastillos.foro_hub2.dominio.usuario.DatosResUsuario;
import co.scastillos.foro_hub2.dominio.usuario.LoginUsuario;
import co.scastillos.foro_hub2.infra.seguridad.UserDatailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class IngresoControler {

    @Autowired
    private UserDatailsServiceImpl userDatailsService;

    @PostMapping("/log-in")
    public ResponseEntity<DatosResUsuario> login(@RequestBody @Valid LoginUsuario loginUsuario){
        return new ResponseEntity<>(this.userDatailsService.loginUser(loginUsuario), HttpStatus.OK);
    }

}
