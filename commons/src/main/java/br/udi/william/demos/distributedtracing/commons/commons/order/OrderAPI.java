package br.udi.william.demos.distributedtracing.commons.commons.order;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(
        value = "/order",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public interface OrderAPI {
    @GetMapping
    List<OrderRepresentation> getOrders();

    @GetMapping("/{id}")
    OrderRepresentation getOrder(@PathVariable("id") String id);

    @PostMapping
    OrderRepresentation createOrder(@RequestBody @Valid OrderCreationRepresentation orderCreationRepresentation);

    @DeleteMapping("/{id}")
    void cancelOrder(@PathVariable("id") String id);
}
