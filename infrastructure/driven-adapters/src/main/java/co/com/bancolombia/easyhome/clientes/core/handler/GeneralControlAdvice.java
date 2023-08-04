package co.com.bancolombia.easyhome.clientes.core.handler;

import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GeneralControlAdvice {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> exception(BusinessException ex) {
        return new ResponseEntity<>(new ErrorMessage(String.valueOf(HttpStatus.BAD_REQUEST.value()),ex.getMessage(), LocalDateTime.now()),
                HttpStatus.BAD_REQUEST);
    }
}