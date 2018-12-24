package cn.kuroneko.kafka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaListenerConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaListenerConsumerApp.class,args);
    }
}
