package br.udi.william.demos.distributedtracing.commons.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceValue {
    @Getter
    private String resource;
    @Getter
    private String value;
}
