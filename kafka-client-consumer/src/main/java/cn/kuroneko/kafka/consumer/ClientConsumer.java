package cn.kuroneko.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClientConsumer {
    @Autowired
    private KafkaConsumer<String,String> kafkaConsumer;

    public void consume(){
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while (true){
            ConsumerRecords<String,String> poll = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record :
                    poll) {
                System.out.println(String.format("key = %s, value = %s",record.key(),record.value()));
            }
        }

    }
}
