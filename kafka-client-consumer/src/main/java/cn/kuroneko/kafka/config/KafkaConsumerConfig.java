package cn.kuroneko.kafka.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public KafkaConsumer<String,String> kafkaConsumer() {
        Properties kafkaProps = new Properties();
        String brokers="myvm.com:9092";
        String groupId="consumer-test";
        kafkaProps.put("bootstrap.servers",brokers);
        kafkaProps.put("group.id",groupId);
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        kafkaProps.put("max.partition.fetch.bytes",4194304);
        kafkaProps.put("group.max.session.timeout.ms",120000);
        KafkaConsumer kafkaConsumer = new KafkaConsumer<String,String>(kafkaProps);
        return kafkaConsumer;
    }
}