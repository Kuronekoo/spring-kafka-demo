package cn.kuroneko.kafka;

import cn.kuroneko.kafka.consumer.ClientConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaClientConsumerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(KafkaClientConsumerApp.class, args);
        ClientConsumer clientConsumer = (ClientConsumer) run.getBean("clientConsumer");
        clientConsumer.consume();
    }
}
