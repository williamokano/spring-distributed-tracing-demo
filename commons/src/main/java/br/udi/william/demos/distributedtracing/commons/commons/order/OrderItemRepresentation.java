package br.udi.william.demos.distributedtracing.commons.commons.order;

import br.udi.william.demos.distributedtracing.commons.commons.catalog.ProductRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderItemRepresentation {
    private ProductRepresentation product;
    private Integer quantity;
}
