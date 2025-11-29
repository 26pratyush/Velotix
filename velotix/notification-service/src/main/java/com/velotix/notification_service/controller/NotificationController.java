package com.velotix.notification_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {
        // For demo: just log to console
        log.info("Success! Notification sent to paipratyush1@gmail.com: Booking confirmed for event '{}', quantity: {}", request.getEventName(), request.getQuantity());
    }
}
