package cn.kuroneko.kafka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaTemplateProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaTemplateProducerApp.class,args);
    }
}
