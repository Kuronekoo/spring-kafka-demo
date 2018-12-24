package cn.kuroneko.kafka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaClientProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaClientProducerApp.class,args);
    }
}
