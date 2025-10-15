package com.bank.notificationservice.models;

import lombok.Data;

@Data
public class NotificationRequest {
    private String to;
    private String subject;
    private String message;
}