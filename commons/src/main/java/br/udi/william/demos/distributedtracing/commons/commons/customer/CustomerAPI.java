package br.udi.william.demos.distributedtracing.commons.commons.customer;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(
        value = "/customers",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public interface CustomerAPI {
    @GetMapping
    List<CustomerRepresentation> listCustomers();

    @GetMapping("/{id}")
    CustomerRepresentation getCustomerById(@PathVariable("id") String id);

    @PostMapping
    CustomerRepresentation createCustomer(@RequestBody @Validated CustomerRepresentation customer);

    @PutMapping("/{id}")
    void updateUpdateCustomer(@PathVariable("id") String id, @RequestBody @Validated CustomerRepresentation request);

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable("id") String id);
}
