package br.udi.william.demos.distributedtracing.commons.commons.catalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRepresentation {
    private String id;
    @Size(max = 64)
    @NotEmpty
    private String name;
    @NotNull
    private Double price;
}
