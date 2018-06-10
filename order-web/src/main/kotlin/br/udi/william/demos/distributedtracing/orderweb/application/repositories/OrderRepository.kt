package br.udi.william.demos.distributedtracing.orderweb.application.repositories

import br.udi.william.demos.distributedtracing.orderweb.application.models.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, String>