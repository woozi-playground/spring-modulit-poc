package team.sipe.modulith.notification

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service
import team.sipe.modulith.notification.internal.Notification
import team.sipe.modulith.notification.internal.NotificationType
import team.sipe.modulith.product.ProductRegistered

/**
 * Public Interface in Spring Modulith
 */
@Service
class NotificationService(
    private val notificationRepository: NotificationRepository
) {

    @ApplicationModuleListener
    fun createNotification(event: ProductRegistered) {
        val notification: Notification = toEntity(event)
        LOG.info(
            "Received notification by event for product {} in date {} by {}.",
            notification.productName,
            notification.date,
            notification.format
        )
        notificationRepository.save(notification)
    }

    private fun toEntity(notification: ProductRegistered) = Notification(
        productName = notification.productName,
        date = notification.date,
        format = NotificationType.of(notification.format)
    )

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(NotificationService::class.java)
    }
}
