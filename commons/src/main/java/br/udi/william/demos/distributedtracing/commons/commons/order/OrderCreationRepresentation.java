package br.udi.william.demos.distributedtracing.commons.commons.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Map;

public class OrderCreationRepresentation {
    private String id;
    @NotEmpty
    @Size(max = 64)
    private String customerId;
    @NotEmpty
    private Map<String, Integer> items;
}
