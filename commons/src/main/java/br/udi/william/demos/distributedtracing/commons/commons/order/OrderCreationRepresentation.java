package br.udi.william.demos.distributedtracing.commons.commons.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreationRepresentation {
    @NotEmpty
    @Size(max = 64)
    private String customerId;
    @NotEmpty
    private Map<String, Integer> items;
}
