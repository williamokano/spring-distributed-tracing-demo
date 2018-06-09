package br.udi.william.demos.distributedtracing.commons.commons.customer;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
public interface CustomerAPI {
    @GetMapping
    List<CustomerRepresentation> listCustomers();

    @GetMapping("/{id}")
    CustomerRepresentation getCustomerById(@PathVariable String id);

    @PostMapping
    CustomerRepresentation createCustomer(@RequestBody @Validated CustomerRepresentation customer);

    @PutMapping("/{id}")
    void updateUpdateCustomer(@PathVariable String id, @RequestBody @Validated CustomerRepresentation request);

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable String id);
}
