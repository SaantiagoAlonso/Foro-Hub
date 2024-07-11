package co.scastillos.foro_hub2.servicio;

import co.scastillos.foro_hub2.dominio.curso.Curso;
import co.scastillos.foro_hub2.dominio.curso.RepoCurso;
import co.scastillos.foro_hub2.dominio.topic.*;
import co.scastillos.foro_hub2.dominio.usuario.RepoUsuario;
import co.scastillos.foro_hub2.dominio.usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private RepoTopic repoTopic;

    @Autowired
    private RepoUsuario repoUsuario;

    @Autowired
    private RepoCurso repoCurso;


    public DatosResTopic obtenerTopic(Long id) {
        Topic topic = repoTopic.getReferenceById(id);
        return new DatosResTopic(topic);
    }

    public DatosResTopic crearTopic(DatosCrearTopic topic) {
        Usuario autor = repoUsuario.findByNombre(topic.autor());
        Curso curso = repoCurso.getReferenceById(topic.id_curso());
        Topic newTopic = new Topic(topic,autor,curso);
        repoTopic.save(newTopic);
        return new DatosResTopic(newTopic);
    }

    @Transactional
    public DatosResTopic actualizarTopic(DatosActualizarTopic topic){
        Topic updateTopic = repoTopic.getReferenceById(topic.id());
        if(topic.titulo() != null){
            updateTopic.setTitulo(topic.titulo());
        }
        if (topic.mensaje() != null){
            updateTopic.setMensaje(topic.mensaje());
        }
        return new DatosResTopic(updateTopic);
    }


    public void eliminarTopic(Long id) {
        repoTopic.delete(repoTopic.getReferenceById(id));
    }

    public Page<DatosResTopic> obtenerTopics(Pageable pageable) {
        return repoTopic.findAll(pageable).map(DatosResTopic::new);
    }
}
