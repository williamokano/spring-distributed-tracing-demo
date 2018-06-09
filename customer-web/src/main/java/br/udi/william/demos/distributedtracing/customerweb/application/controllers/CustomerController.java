package br.udi.william.demos.distributedtracing.customerweb.application.controllers;

import br.udi.william.demos.distributedtracing.commons.commons.ResourceValue;
import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerAPI;
import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerRepresentation;
import br.udi.william.demos.distributedtracing.commons.commons.exception.NotFoundException;
import br.udi.william.demos.distributedtracing.customerweb.application.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
public class CustomerController implements CustomerAPI {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Autowired
    CustomerController(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

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
        throw NotFoundException.of(ResourceValue.builder()
                .resource("Customer")
                .value(id)
                .build());
    }

    @ResponseStatus(CREATED)
    @Override
    public CustomerRepresentation createCustomer(@RequestBody @Validated CustomerRepresentation customer) {
        return CustomerRepresentation.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @ResponseStatus(NO_CONTENT)
    @Override
    public void updateUpdateCustomer(@PathVariable String id, @RequestBody @Validated CustomerRepresentation request) {

    }

    @ResponseStatus(NO_CONTENT)
    @Override
    public void deleteCustomer(@PathVariable String id) {

    }
}
