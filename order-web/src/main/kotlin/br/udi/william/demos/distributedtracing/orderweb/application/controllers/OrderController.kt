package br.udi.william.demos.distributedtracing.orderweb.application.controllers

import br.udi.william.demos.distributedtracing.commons.commons.catalog.CatalogAPI
import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerAPI
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderAPI
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderCreationRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderItemRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderRepresentation
import br.udi.william.demos.distributedtracing.orderweb.application.models.OrderItem
import br.udi.william.demos.distributedtracing.orderweb.application.repositories.OrderRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
open class OrderController(
    private val orderRepository: OrderRepository,
    private val customerAPI: CustomerAPI,
    private val catalogAPI: CatalogAPI
) : OrderAPI {

    @ResponseStatus(HttpStatus.OK)
    override fun getOrders(): List<OrderRepresentation> {
        return orderRepository.findAll().map {
            OrderRepresentation.builder()
                .id(it.id)
                .customer(customerAPI.getCustomerById("${it.customerId}"))
                .total(it.price)
                .items(buildItemsList(it.items))
                .orderStatus(OrderRepresentation.OrderStatus.valueOf(it.status!!))
                .build()
        }
    }

    private fun buildItemsList(items: List<OrderItem>): List<OrderItemRepresentation> =
        items.map(this::buildOrderItemRepresentation)

    private fun buildOrderItemRepresentation(orderItem: OrderItem): OrderItemRepresentation =
        OrderItemRepresentation.builder()
            .product(catalogAPI.getProduct(orderItem.productId))
            .quantity(orderItem.quantity)
            .build()

    @ResponseStatus(HttpStatus.OK)
    override fun getOrder(@PathVariable("id") id: String): OrderRepresentation {
        return OrderRepresentation()
    }

    @ResponseStatus(HttpStatus.CREATED)
    override fun createOrder(orderCreationRepresentation: OrderCreationRepresentation?): OrderRepresentation {
        return OrderRepresentation()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun cancelOrder(@PathVariable("id") id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}