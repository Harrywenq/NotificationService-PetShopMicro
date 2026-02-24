package com.huytpq.notification_service.listener;

import com.huytpq.notification_service.event.OrderPlacedEvent;
import com.huytpq.notification_service.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    private final EmailService emailService;

    public OrderEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "order-topic", groupId = "notification-group", containerFactory = "orderPlacedEventListenerFactory")
    public void handleOrderEvent(OrderPlacedEvent event) {
        System.out.println("Received event from Kafka: " + event);
        // Thực hiện gửi email ở đây
        emailService.sendOrderEmail(event);
    }
}
