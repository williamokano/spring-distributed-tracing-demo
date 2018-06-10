package br.udi.william.demos.distributedtracing.commons.commons.order;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/order",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public interface OrderAPI {
    OrderRepresentation getOrder(@PathVariable String id);

    OrderRepresentation createOrder(@RequestBody @Valid OrderRepresentation orderRepresentation);

    void cancelOrder(@PathVariable String id);
}
