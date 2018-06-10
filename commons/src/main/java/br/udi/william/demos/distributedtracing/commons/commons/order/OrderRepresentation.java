package br.udi.william.demos.distributedtracing.commons.commons.order;

import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRepresentation {
    private String id;
    @NotNull
    private CustomerRepresentation customer;
    @NotEmpty
    private List<OrderItemRepresentation> items;
    @NotNull
    private Double total;
    private OrderStatus orderStatus;

    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        PREPARING,
        DELIVERY,
        COMPLETED
    }
}
