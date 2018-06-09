package br.udi.william.demos.distributedtracing.customerweb.application.services;

import br.udi.william.demos.distributedtracing.customerweb.application.models.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer findCustomerById(String id);

    Customer createCustomer(Customer customer);
}
