package br.udi.william.demos.distributedtracing.catalogweb.application.services

import br.udi.william.demos.distributedtracing.catalogweb.application.models.Product
import org.springframework.stereotype.Service

@Service
interface ProductService {
    fun findByIdOrFail(id: String): Product
    fun create(product: Product): Product
}