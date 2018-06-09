package br.udi.william.demos.distributedtracing.commons.commons;

import br.udi.william.demos.distributedtracing.commons.commons.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResourceValue handleNotFoundException(NotFoundException notFoundException) {
        return notFoundException.getResourceValue();
    }
}
