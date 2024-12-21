package team.sipe.modulith.product

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sipe.modulith.notification.NotificationService
import team.sipe.modulith.notification.internal.NotificationType
import team.sipe.modulith.product.domain.Product
import team.sipe.modulith.product.infrastructure.ProductRepository
import java.util.Date

/**
 * Public Interface in Spring Modulith
 */
@Service
class ProductService(
    private val events: ApplicationEventPublisher,
    private val productRepository: ProductRepository,
    private val notificationService: NotificationService
) {

    /**
     * NotificationService 를 사용하여 DTO 를 직접 전달하는 방법
     * DTO 의 경우 의존성을 가진 모듈에서 정의해야하며 데이터 통신(DOP)을 위해 사용됩니다.
     */
    @Transactional
    fun create(product: Product) {
        val product = productRepository.save(product)
        notificationService.createNotification(
            ProductRegistered(
                productName = product.name,
                date = Date(),
                format = NotificationType.SMS.name,
            )
        )
    }

    /**
     * ApplicationEventPublisher 를 사용하여 이벤트를 발행하는 방법
     */
    @Transactional
    fun createWithEvent(product: ProductCreationCommand): Product {
        val product = productRepository.save(Product(product.name, product.price, product.description, null))
        events.publishEvent(ProductRegistered(product.name, Date(), NotificationType.SMS.name))
        return product
    }
}