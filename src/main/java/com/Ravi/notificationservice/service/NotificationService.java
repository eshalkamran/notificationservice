package com.Ravi.notificationservice.service;

import com.Ravi.notificationservice.model.Notification;
import com.Ravi.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        System.out.println("Sending notification to " + notification.getUsername() + ": " + notification.getMessage());
        return notificationRepository.save(notification);
    }
}
