package team.sipe.modulith.product

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import team.sipe.modulith.notification.NotificationDto
import team.sipe.modulith.notification.NotificationService
import team.sipe.modulith.notification.internal.NotificationType
import team.sipe.modulith.product.internal.Product
import java.util.Date

/**
 * Public Interface in Spring Modulith
 */
@Service
class ProductService(
    private val events: ApplicationEventPublisher,
    private val notificationService: NotificationService
) {

    /**
     * NotificationService 를 사용하여 DTO 를 직접 전달하는 방법
     * DTO 의 경우 의존성을 가진 모듈에서 정의해야하며 데이터 통신(DOP)을 위해 사용됩니다.
     */
    fun create(product: Product) {
        notificationService.createNotification(
            NotificationDto(
                productName = product.name,
                date = Date(),
                format = NotificationType.SMS.name,
            )
        )
    }

    /**
     * ApplicationEventPublisher 를 사용하여 이벤트를 발행하는 방법
     */
    fun createWithEvent(product: Product) {
        events.publishEvent(NotificationDto(product.name, Date(), NotificationType.SMS.name))
    }
}