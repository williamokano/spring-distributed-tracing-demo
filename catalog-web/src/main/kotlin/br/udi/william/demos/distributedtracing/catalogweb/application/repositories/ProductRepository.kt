package br.udi.william.demos.distributedtracing.catalogweb.application.repositories

import br.udi.william.demos.distributedtracing.catalogweb.application.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String>