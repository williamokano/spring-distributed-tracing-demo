package br.udi.william.demos.distributedtracing.commons.commons.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerRepresentation {
    private String id;
    @NotEmpty
    @Size(max = 64)
    private String name;
    @NotEmpty
    @Size(max = 64)
    private String lastname;
}
