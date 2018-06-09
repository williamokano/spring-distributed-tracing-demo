package br.udi.william.demos.distributedtracing.customerweb.application.controllers;

import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerAPI;
import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerRepresentation;
import br.udi.william.demos.distributedtracing.customerweb.application.models.Customer;
import br.udi.william.demos.distributedtracing.customerweb.application.repositories.CustomerRepository;
import br.udi.william.demos.distributedtracing.customerweb.application.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerAPI {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    private CustomerService customerService;

    @ResponseStatus(OK)
    @Override
    public List<CustomerRepresentation> listCustomers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerRepresentation.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(OK)
    @Override
    public CustomerRepresentation getCustomerById(@PathVariable String id) {
        Customer customer = customerService.findCustomerById(id);

        return modelMapper.map(customer, CustomerRepresentation.class);
    }

    @ResponseStatus(CREATED)
    @Override
    public CustomerRepresentation createCustomer(@RequestBody @Valid CustomerRepresentation customer) {
        return CustomerRepresentation.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @ResponseStatus(NO_CONTENT)
    @Override
    public void updateUpdateCustomer(@PathVariable String id, @RequestBody @Valid CustomerRepresentation request) {

    }

    @ResponseStatus(NO_CONTENT)
    @Override
    public void deleteCustomer(@PathVariable String id) {

    }
}
