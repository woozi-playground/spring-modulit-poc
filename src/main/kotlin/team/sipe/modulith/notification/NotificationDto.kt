package team.sipe.modulith.notification

import java.util.Date

/**
 * Data Transfer Object
 */
data class NotificationDto(
    val productName: String,
    val date: Date,
    val format: String,
) {

}