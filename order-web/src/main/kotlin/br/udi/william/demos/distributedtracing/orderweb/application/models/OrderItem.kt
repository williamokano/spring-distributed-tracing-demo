package br.udi.william.demos.distributedtracing.orderweb.application.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "order_items")
data class OrderItem(
    @field:[Id Column(name = "order_id")]
    var orderId: String? = null,
    var productId: String? = null,
    var quantity: Int? = null
)
