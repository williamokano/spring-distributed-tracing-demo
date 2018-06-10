package br.udi.william.demos.distributedtracing.catalogweb.application.repositories

import br.udi.william.demos.distributedtracing.catalogweb.application.models.Product
import br.udi.william.demos.distributedtracing.catalogweb.application.services.ProductService
import br.udi.william.demos.distributedtracing.commons.commons.ResourceValue
import br.udi.william.demos.distributedtracing.commons.commons.exception.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    override fun findByIdOrFail(id: String): Product =
        productRepository.findOne(id) ?: throw NotFoundException.of(ResourceValue("product", id))

    override fun create(product: Product): Product =
        product
            .apply { id = UUID.randomUUID().toString() }
            .let { productRepository.save(it) }
}