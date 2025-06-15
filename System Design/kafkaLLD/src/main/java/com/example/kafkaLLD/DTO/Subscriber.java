package com.example.kafkaLLD.DTO;


import java.util.ArrayList;
import java.util.List;


public class Subscriber {

    private final String consumerId;

    public Subscriber(String consumerId) {
        this.consumerId = consumerId;
    }

    public List<Message> subscribe(Topic topic) {
        List<Message> messages = new ArrayList<>();
        for (Partition partition : topic.getPartitions()) {
            partition.registerSubscriber(this);
            new Thread(()->messages.addAll(consumeMessages(partition))).start();
        }
        return messages;
    }

    private List<Message> consumeMessages(Partition partition){
        List<Message> messages = new ArrayList<>();
        boolean hasMoreMessages = true;
        while(hasMoreMessages){
            Message message = partition.getNextMessageForSubscriber(this);
            if(message!=null){
                messages.add(message);
            }
            hasMoreMessages=false;
        }
        return messages;
    }

    public String getConsumerId() {
        return consumerId;
    }
}
