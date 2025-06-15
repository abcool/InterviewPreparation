package com.example.kafkaLLD.DTO;



import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Partition {
    private final int partitionId;
    private final List<Message> messages;
    private final Map<Subscriber, AtomicInteger> offsets;

    public Partition(int partitionId) {
        this.partitionId = partitionId;
        this.messages = Collections.synchronizedList(new ArrayList<>());
        this.offsets = Collections.synchronizedMap(new HashMap<>());
    }
    public int getPartitionId() {
        return partitionId;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void addMessage(Message message) {
        messages.add(message);
    }
    public void registerSubscriber(Subscriber subscriber) {
        offsets.putIfAbsent(subscriber, new AtomicInteger(0));
    }

    public Message getNextMessageForSubscriber(Subscriber subscriber) {
        AtomicInteger offset = offsets.get(subscriber);
        int currentOffset = offset.get();
        if (currentOffset < messages.size()) {
            offset.incrementAndGet(); // Move to the next message
            return messages.get(currentOffset);

        } else {
            System.out.println("No more messages for subscriber: " + subscriber.getConsumerId());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Partition{" +
                "partitionId='" + partitionId + '\'' +
                ", messages=" + messages +
                '}';
    }
}
