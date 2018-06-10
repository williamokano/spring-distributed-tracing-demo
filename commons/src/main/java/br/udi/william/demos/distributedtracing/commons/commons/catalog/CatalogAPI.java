package br.udi.william.demos.distributedtracing.commons.commons.catalog;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
public interface CatalogAPI {
    @GetMapping
    List<ProductRepresentation> getProducts();

    @GetMapping("/{id}")
    ProductRepresentation getProduct(@PathVariable String id);

    @PostMapping
    ProductRepresentation createProduct(@RequestBody @Validated ProductRepresentation product);

    @PutMapping("/{id}")
    void updateProduct(@PathVariable String id, @RequestBody @Validated ProductRepresentation product);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable String id);
}
