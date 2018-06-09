package br.udi.william.demos.distributedtracing.commons.commons.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRepresentation {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String lastname;
}
