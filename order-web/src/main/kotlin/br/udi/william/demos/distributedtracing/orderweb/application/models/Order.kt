package br.udi.william.demos.distributedtracing.orderweb.application.models

import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    var id: String? = null,
    var customerId: String? = null,
    var price: Double? = null,
    var status: String? = null,

    @field:[OneToMany JoinColumn(name = "order_id")]
    var items: List<OrderItem> = mutableListOf()
)