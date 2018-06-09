package br.udi.william.demos.distributedtracing.commons.commons.customer;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerRepresentation {
    private String id;
    private String name;
    private String lastname;
}
