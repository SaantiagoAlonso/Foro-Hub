package co.scastillos.foro_hub2.controlador;

import co.scastillos.foro_hub2.dominio.respuesta.DatosCrearRespuesta;
import co.scastillos.foro_hub2.dominio.respuesta.DatosRespuesta;
import co.scastillos.foro_hub2.servicio.ServicioRespuesta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Respuesta")
public class RespuestaControler {

    @Autowired
    private ServicioRespuesta servicioRespuesta;

    @PostMapping
    public ResponseEntity<DatosRespuesta>  publicarRespuesta(@RequestBody @Valid DatosCrearRespuesta datosCrearRespuesta, UriComponentsBuilder uriComponentsBuilder){
        DatosRespuesta respuesta = servicioRespuesta.crearRespuesta(datosCrearRespuesta);
        URI url = uriComponentsBuilder.path("/Respuesta/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(url).body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuesta> verRespuesta(@PathVariable Long id){
        return ResponseEntity.ok( servicioRespuesta.obtenerRespuesta(id));
    }


}
