package br.udi.william.demos.distributedtracing.commons.commons;

import br.udi.william.demos.distributedtracing.commons.commons.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResourceValue handleNotFoundException(NotFoundException notFoundException) {
        return notFoundException.getResourceValue();
    }
}
