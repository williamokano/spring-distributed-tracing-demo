package br.udi.william.demos.distributedtracing.commons.commons.catalog;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(
        value = "/products",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
)
public interface CatalogAPI {
    @GetMapping
    List<ProductRepresentation> getProducts();

    @GetMapping("/{id}")
    ProductRepresentation getProduct(@PathVariable("id") String id);

    @PostMapping
    ProductRepresentation createProduct(@RequestBody @Validated ProductRepresentation product);

    @PutMapping("/{id}")
    void updateProduct(@PathVariable("id") String id, @RequestBody @Validated ProductRepresentation product);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable("id") String id);
}
