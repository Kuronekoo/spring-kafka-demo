package cn.kuroneko.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {
    @Bean
    public KafkaProducer kafkaProducer() {
        String brockers = "myvm.com:9092";
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers",brockers);
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer<String,String>(kafkaProps);
        return kafkaProducer;
    }
}
