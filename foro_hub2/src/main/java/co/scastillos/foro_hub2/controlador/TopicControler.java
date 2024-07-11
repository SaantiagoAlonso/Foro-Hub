package co.scastillos.foro_hub2.controlador;


import co.scastillos.foro_hub2.dominio.topic.DatosActualizarTopic;
import co.scastillos.foro_hub2.dominio.topic.DatosCrearTopic;
import co.scastillos.foro_hub2.dominio.topic.DatosResTopic;
import co.scastillos.foro_hub2.servicio.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicControler {

    @Autowired
    private TopicService topicService;

    @GetMapping("/{id}")
    public ResponseEntity<DatosResTopic> verTopic(@PathVariable Long id){
        return ResponseEntity.ok(topicService.obtenerTopic(id));
    }

    @GetMapping
    public ResponseEntity<Page<DatosResTopic>> listarTopics(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(topicService.obtenerTopics(pageable));
    }

    @PostMapping
    public ResponseEntity<DatosResTopic> publicar(@RequestBody @Valid DatosCrearTopic topic, UriComponentsBuilder uriComponentsBuilder){
        DatosResTopic newTopic = topicService.crearTopic(topic);
        URI url = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(newTopic.id()).toUri();
        return ResponseEntity.created(url).body(newTopic);
    }


    @PutMapping
    public ResponseEntity<DatosResTopic> modificarTopic(@RequestBody @Valid DatosActualizarTopic topic){
        return ResponseEntity.ok(topicService.actualizarTopic(topic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarTopic(@PathVariable Long id){
        topicService.eliminarTopic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
