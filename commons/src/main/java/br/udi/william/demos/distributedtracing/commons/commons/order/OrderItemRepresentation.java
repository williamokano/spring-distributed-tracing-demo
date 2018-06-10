package br.udi.william.demos.distributedtracing.commons.commons.order;

import br.udi.william.demos.distributedtracing.commons.commons.catalog.ProductRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemRepresentation {
    private ProductRepresentation product;
    private Integer quantity;
}
