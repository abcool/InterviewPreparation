package com.example.kafkaLLD.DTO;


import java.util.Random;
import java.util.UUID;


public class Publisher {
    private final String publisherId;
    private final Random random = new Random();

    public Publisher() {
        this.publisherId = UUID.randomUUID().toString();
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String PublishMessage(Topic topic, String message) {
        int partitionId = random.nextInt(topic.getPartitions().size());
        Partition partition = topic.getPartition(partitionId);
        Message content = new Message(message);
        partition.addMessage(content);
        return "Publisher: "+ getPublisherId() + " published  "+ content.getMessage() + " message successfully " +
                "to partiton: "+partitionId;
    }


}
