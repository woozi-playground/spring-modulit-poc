package team.sipe.modulith.product

data class ProductCreationCommand(
    val name: String,
    val price: Int,
    val description: String
)