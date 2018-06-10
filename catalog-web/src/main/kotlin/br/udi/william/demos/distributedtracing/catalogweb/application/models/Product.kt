package br.udi.william.demos.distributedtracing.catalogweb.application.models

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "products")
data class Product(
    @field:Id
    var id: String? = null,

    @field:[NotEmpty Size(max = 64)]
    var name: String? = null,

    @field:NotNull
    var price: Double? = null
)