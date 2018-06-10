package br.udi.william.demos.distributedtracing.catalogweb.application.controllers

import br.udi.william.demos.distributedtracing.catalogweb.application.models.Product
import br.udi.william.demos.distributedtracing.catalogweb.application.repositories.ProductRepository
import br.udi.william.demos.distributedtracing.catalogweb.application.services.ProductService
import br.udi.william.demos.distributedtracing.commons.commons.catalog.CatalogAPI
import br.udi.william.demos.distributedtracing.commons.commons.catalog.ProductRepresentation
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
open class CatalogController(
    private val productRepository: ProductRepository,
    private val productService: ProductService,
    private val modelMapper: ModelMapper
) : CatalogAPI {
    @ResponseStatus(HttpStatus.OK)
    override fun getProducts(): List<ProductRepresentation> =
        productRepository.findAll().map { modelMapper.map(it, ProductRepresentation::class.java) }

    @ResponseStatus(HttpStatus.OK)
    override fun getProduct(@PathVariable id: String): ProductRepresentation =
        productService.findByIdOrFail(id)
            .let { modelMapper.map(it, ProductRepresentation::class.java) }

    @ResponseStatus(HttpStatus.CREATED)
    override fun createProduct(@RequestBody @Valid product: ProductRepresentation): ProductRepresentation =
        product
            .let { modelMapper.map(it, Product::class.java) }
            .let { productService.create(it) }
            .let { modelMapper.map(it, ProductRepresentation::class.java) }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun updateProduct(@PathVariable id: String, @RequestBody @Valid product: ProductRepresentation?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun deleteProduct(@PathVariable id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}