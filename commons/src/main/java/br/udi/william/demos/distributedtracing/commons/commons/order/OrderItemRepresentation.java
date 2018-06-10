package br.udi.william.demos.distributedtracing.commons.commons.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemRepresentation {
    private String productId;
    private Long quantity;
}
