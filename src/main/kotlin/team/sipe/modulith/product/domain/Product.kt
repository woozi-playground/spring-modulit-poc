package team.sipe.modulith.product.domain

import org.springframework.data.annotation.Id

/**
 * Domain Entity
 */
data class Product(
    val name: String,
    val price: Int,
    val description: String,
    @Id val id: Long? = null
)