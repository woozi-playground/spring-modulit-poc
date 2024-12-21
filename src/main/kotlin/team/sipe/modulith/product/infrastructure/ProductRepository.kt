package team.sipe.modulith.product.infrastructure

import team.sipe.modulith.product.domain.Product
import org.springframework.data.repository.ListCrudRepository;

interface ProductRepository: ListCrudRepository<Product, Long> {
}