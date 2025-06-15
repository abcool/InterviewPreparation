package com.example.kafkaLLD.DTO;


import java.util.ArrayList;
import java.util.List;


public class Topic {
    private final String topicName;
    private final List<Partition> partitions;

    public Topic(String topicName, int partitionCount) {
        this.topicName = topicName;
        this.partitions = new ArrayList<>(partitionCount);
        for (int i = 0; i < partitionCount; i++) {
            partitions.add(new Partition(i));
        }
    }
    public String getTopicName() {
        return topicName;
    }
    public List<Partition> getPartitions() {
        return partitions;
    }
    public Partition getPartition(int partitionId){
        return partitions.get(partitionId);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                ", partitions=" + partitions +
                '}';
    }

}
