package cn.kuroneko.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerConsumer {
    @KafkaListener(topics = {"test"})
    public void consume(ConsumerRecord record){
            System.out.println(String.format("key = %s, value = %s",record.key(),record.value()));
    }
}
