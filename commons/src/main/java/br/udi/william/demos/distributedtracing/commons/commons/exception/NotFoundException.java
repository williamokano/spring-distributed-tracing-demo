package br.udi.william.demos.distributedtracing.commons.commons.exception;

import br.udi.william.demos.distributedtracing.commons.commons.ResourceValue;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    @Getter
    private ResourceValue resourceValue;

    private NotFoundException(ResourceValue resourceValue) {
        this.resourceValue = resourceValue;
    }

    public static NotFoundException of(ResourceValue resourceValue) {
        return new NotFoundException(resourceValue);
    }
}
