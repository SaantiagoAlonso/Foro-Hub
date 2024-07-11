package co.scastillos.foro_hub2.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErrores {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var error = e.getFieldErrors().stream().map(DatosError::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    private record DatosError (String campo,String error){
        public DatosError(FieldError e){
            this(e.getField(),e.getDefaultMessage());

        }
    }

}
