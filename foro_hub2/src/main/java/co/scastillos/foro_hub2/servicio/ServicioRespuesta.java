package co.scastillos.foro_hub2.servicio;

import co.scastillos.foro_hub2.dominio.respuesta.DatosCrearRespuesta;
import co.scastillos.foro_hub2.dominio.respuesta.DatosRespuesta;
import co.scastillos.foro_hub2.dominio.respuesta.RepoRespuesta;
import co.scastillos.foro_hub2.dominio.respuesta.Respuesta;
import co.scastillos.foro_hub2.dominio.topic.RepoTopic;
import co.scastillos.foro_hub2.dominio.topic.Topic;
import co.scastillos.foro_hub2.dominio.usuario.RepoUsuario;
import co.scastillos.foro_hub2.dominio.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRespuesta {

    @Autowired
    private RepoRespuesta repoRespuesta;

    @Autowired
    private RepoUsuario repoUsuario;

    @Autowired
    private RepoTopic repoTopic;

    public DatosRespuesta crearRespuesta(DatosCrearRespuesta datosCrearRespuesta) {
        Usuario autor = repoUsuario.findByNombre(datosCrearRespuesta.autor());
        Topic topic = repoTopic.getReferenceById(datosCrearRespuesta.id_topic());
        Respuesta respuesta = new Respuesta(datosCrearRespuesta,autor,topic);
        repoRespuesta.save(respuesta);
        return new DatosRespuesta(respuesta);
    }

    public DatosRespuesta obtenerRespuesta(Long id) {
        Respuesta respuesta = repoRespuesta.getReferenceById(id);
        return new DatosRespuesta(respuesta);
    }
}
