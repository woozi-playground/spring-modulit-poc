package team.sipe.modulith.product

import java.util.Date

/**
 * Data Transfer Object
 */
data class ProductRegistered(
    val productName: String,
    val date: Date,
    val format: String,
)