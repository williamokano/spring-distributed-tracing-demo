package br.udi.william.demos.distributedtracing.orderweb.application.controllers

import br.udi.william.demos.distributedtracing.commons.commons.customer.CustomerAPI
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderAPI
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderCreationRepresentation
import br.udi.william.demos.distributedtracing.commons.commons.order.OrderRepresentation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
open class OrderController(
    private val customerAPI: CustomerAPI
) : OrderAPI {

    @ResponseStatus(HttpStatus.OK)
    override fun getOrders(): List<OrderRepresentation> {
        return emptyList()
    }

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