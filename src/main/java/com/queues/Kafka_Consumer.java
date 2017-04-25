package com.queues;

import java.util.Arrays;
import java.util.Properties;
 
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Kafka_Consumer {
	 
	  public Kafka_Consumer recieve () {
		  
	    Properties props = new Properties();
	    
	    props.put("bootstrap.servers", "192.168.33.10:9092");
	    props.put("group.id", "group-1");
	    props.put("enable.auto.commit", "true");
	    props.put("auto.commit.interval.ms", "1000");
	    props.put("auto.offset.reset", "earliest");
	    props.put("session.timeout.ms", "30000");
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	 
	    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
	    kafkaConsumer.subscribe(Arrays.asList("HelloKafkaTopic"));
	    
	    try {
	    
	    	while (true) {
		      
	    	ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
		    
	    	for (ConsumerRecord<String, String> record : records) {
	    		// receive, decode and deserialize objects
		        System.out.printf("offset = %d, value = %s", record.offset(), record.value());
		        System.out.println();
		      }
	    	}
	    
	    } catch (Exception e) {
	    	
	    	} finally {
	    		kafkaConsumer.close();
	    	}
	 
	    return new Kafka_Consumer();
	  }
	 
}

