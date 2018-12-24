package cn.kuroneko.kafka.producer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/kafka/producer")
public class KafkaClientProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send/async")
    public Object sendAsync(@RequestBody JSONObject params){
        String key = params.getString("key");
        String value = params.getString("value");
        Random random=new Random();
        int partition = random.nextInt(3);
        ProducerRecord<String, String> record = new ProducerRecord<String,String>("test", 0, key, value);
        kafkaProducer.send(record, (m,e)->{
            if (e != null) {
                System.err.println("发送消息失败：" + e.getStackTrace());
            }
            if (m != null) {
                System.out.println("异步方式发送消息结果：" + "topic-" + m.topic() + "|partition-"
                        + m.partition() + "|offset-" + m.offset());
            }
        });
//        kafkaProducer.close();
        return "succ";
    }


    @PostMapping("/send/sync")
    public Object sendSync(@RequestBody JSONObject params){
        String key = params.getString("key");
        String value = params.getString("value");
        ProducerRecord<String, String> record = new ProducerRecord<String,String>("test", 0, key, value);
        kafkaProducer.send(record);
//        kafkaProducer.close();
        return "succ";
    }

}
