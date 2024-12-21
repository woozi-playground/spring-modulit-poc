package team.sipe.modulith.product

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import team.sipe.modulith.product.domain.Product
import java.net.URI

@RestController
class ProductApi(
    private val productService: ProductService
) {

    @PostMapping("/products")
    fun createProduct(
        @RequestBody productCreationHttpRequest: ProductCreationHttpRequest): ResponseEntity<Product> {
        val product = productService.createWithEvent(
            ProductCreationCommand(
                productCreationHttpRequest.name,
                productCreationHttpRequest.price,
                productCreationHttpRequest.description,
                )
        )
        return ResponseEntity.created(URI.create("/products/${product.id}")).body(product)
    }
}

data class ProductCreationHttpRequest(
    val name: String,
    val price: Int,
    val description: String,
)