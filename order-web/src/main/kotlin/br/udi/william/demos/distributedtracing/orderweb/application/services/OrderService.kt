package br.udi.william.demos.distributedtracing.orderweb.application.services

import br.udi.william.demos.distributedtracing.orderweb.application.models.Order
import br.udi.william.demos.distributedtracing.orderweb.application.repositories.OrderRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)!!
    }

    fun createOrder(order: Order): Order =
        try {
            orderRepository.save(order)
        } catch (e: Throwable) {
            logger.error("Failed to create order", e)
            throw e
        }
}