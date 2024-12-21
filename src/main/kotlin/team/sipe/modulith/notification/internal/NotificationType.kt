package team.sipe.modulith.notification.internal

/**
 * Domain VO
 */
enum class NotificationType {
    SMS;

    companion object {
        fun of(format: String): NotificationType  =
            entries.firstOrNull { it.name.equals(format, ignoreCase = true) }
                ?: throw IllegalArgumentException("Invalid notification format: $format")
    }
}