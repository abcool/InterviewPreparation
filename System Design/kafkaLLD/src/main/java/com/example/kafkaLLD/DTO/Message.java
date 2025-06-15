package com.example.kafkaLLD.DTO;


import java.util.Objects;
import java.util.UUID;

public class Message {
    private final String messageId;
    private final String message;

    public Message(String message) {
        this.message = message;
        this.messageId = UUID.randomUUID().toString();
    }
    public String getMessage(){
        return message;
    }
    public String getMessageId() {
        return messageId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + messageId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Message message1)) return false;
        return Objects.equals(messageId, message1.messageId) && Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, message);
    }
}
