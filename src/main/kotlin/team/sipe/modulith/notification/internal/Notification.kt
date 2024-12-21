package team.sipe.modulith.notification.internal

import org.springframework.data.annotation.Id
import java.util.Date

/**
 * Domain Entity
 */
data class Notification(
    val productName: String,
    val date: Date,
    val format: NotificationType,
    @Id val id: Long? = null
) {
}