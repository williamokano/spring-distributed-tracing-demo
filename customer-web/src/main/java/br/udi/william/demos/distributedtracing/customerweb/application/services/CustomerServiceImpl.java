package br.udi.william.demos.distributedtracing.customerweb.application.services;

import br.udi.william.demos.distributedtracing.commons.commons.ResourceValue;
import br.udi.william.demos.distributedtracing.commons.commons.exception.NotFoundException;
import br.udi.william.demos.distributedtracing.customerweb.application.models.Customer;
import br.udi.william.demos.distributedtracing.customerweb.application.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    @NotNull
    public Customer findCustomerById(String id) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw NotFoundException.of(ResourceValue.builder()
                    .resource("customer")
                    .value(id)
                    .build());
        }

        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }
}
