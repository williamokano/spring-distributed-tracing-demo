package br.udi.william.demos.distributedtracing.orderweb.application.controllers

import br.udi.william.demos.distributedtracing.commons.commons.catalog.CatalogAPI
import br.udi.william.demos.distributedtracing.commons.commons.catalog.ProductRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerAPI
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderAPI
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderCreationRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderItemRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderRepresentation.OrderStatus
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderRepresentation.builder
import br.udi.william.demos.distributedtracing.orderweb.application.models.Order
import br.udi.william.demos.distributedtracing.orderweb.application.models.OrderItem
import br.udi.william.demos.distributedtracing.orderweb.application.repositories.OrderRepository
import br.udi.william.demos.distributedtracing.orderweb.application.util.ContextHolder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.stream.Collectors

@RestController
open class OrderController(
    private val orderRepository: OrderRepository,
    private val customerAPI: CustomerAPI,
    private val catalogAPI: CatalogAPI,
    private val executorService: ExecutorService
) : OrderAPI {

    @ResponseStatus(HttpStatus.OK)
    override fun getOrders(): List<OrderRepresentation> {
        return orderRepository.findAll().map {
            builder()
                .id(it.id)
                .customer(customerAPI.getCustomerById(it.customerId))
                .total(it.price)
                .items(buildItemsList(it.items))
                .orderStatus(OrderStatus.valueOf(it.status!!))
                .build()
        }
    }

    @ResponseStatus(HttpStatus.OK)
    override fun getOrder(@PathVariable("id") id: String): OrderRepresentation {
        return OrderRepresentation()
    }

    @ResponseStatus(HttpStatus.CREATED)
    override fun createOrder(@RequestBody order: OrderCreationRepresentation): OrderRepresentation {
        val customer = customerAPI.getCustomerById(order.customerId)

        val items = order.items.keys.parallelStream().map { catalogAPI.getProduct(it) }.collect(Collectors.toList())

        val orderItems =
            order.items.mapValues { OrderItem(productId = it.key, quantity = it.value) }.map { it.value }

        val createdOrder = Order(
            id = UUID.randomUUID().toString(),
            customerId = customer.id,
            items = orderItems.toList(),
            price = items.sumByDouble { it.price },
            status = "PENDING"
        )

        println(ContextHolder.getContext())
        println(Thread.currentThread().name)
        executorService.submit {
            println(Thread.currentThread().name)
            println(ContextHolder.getContext())
        }

        return builder()
            .id(createdOrder.id)
            .customer(customer)
            .items(items.map {
                OrderItemRepresentation.builder()
                    .product(
                        ProductRepresentation.builder()
                            .id(it.id)
                            .name(it.name)
                            .price(it.price)
                            .build()
                    )
                    .quantity(order.items[it.id])
                    .build()
            })
            .total(createdOrder.price)
            .orderStatus(OrderStatus.valueOf(createdOrder.status!!))
            .build()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun cancelOrder(@PathVariable("id") id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun buildItemsList(items: List<OrderItem>): List<OrderItemRepresentation> =
        items.map(this::buildOrderItemRepresentation)

    private fun buildOrderItemRepresentation(orderItem: OrderItem): OrderItemRepresentation =
        OrderItemRepresentation.builder()
            .product(catalogAPI.getProduct(orderItem.productId))
            .quantity(orderItem.quantity)
            .build()
}
