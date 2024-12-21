package team.sipe.modulith.notification

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service
import team.sipe.modulith.notification.internal.Notification
import team.sipe.modulith.notification.internal.NotificationType

/**
 * Public Interface in Spring Modulith
 */
@Service
class NotificationService {

    @ApplicationModuleListener
    fun notificationEvent(event: NotificationDto) {
        val notification: Notification = toEntity(event)
        LOG.info(
            "Received notification by event for product {} in date {} by {}.",
            notification.productName,
            notification.date,
            notification.format
        )
    }

    fun createNotification(notification: NotificationDto) {
        this.createNotification(toEntity(notification))
    }

    private fun toEntity(notification: NotificationDto) = Notification(
        productName = notification.productName,
        date = notification.date,
        format = NotificationType.of(notification.format)
    )

    fun createNotification(notification: Notification) {
        LOG.info(
            "Received notification by module dependency for product {} in date {} by {}.",
            notification.productName,
            notification.date,
            notification.format
        )
    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(NotificationService::class.java)
    }
}
