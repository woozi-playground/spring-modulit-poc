package team.sipe.modulith.notification.internal

import java.util.Date

/**
 * Domain Entity
 */
data class Notification(
    val productName: String,
    val date: Date,
    val format: NotificationType
) {
}