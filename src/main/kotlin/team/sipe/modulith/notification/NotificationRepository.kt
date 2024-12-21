package team.sipe.modulith.notification

import org.springframework.data.repository.ListCrudRepository
import team.sipe.modulith.notification.internal.Notification

interface NotificationRepository: ListCrudRepository<Notification, Long>{
}