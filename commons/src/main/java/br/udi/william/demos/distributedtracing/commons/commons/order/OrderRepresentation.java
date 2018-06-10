package br.udi.william.demos.distributedtracing.commons.commons.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRepresentation {
    private String id;
    @NotEmpty
    @Size(max = 64)
    private String customerId;
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
