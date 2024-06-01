package com.javatechie.consumer;

import com.javatechie.dto.Product;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @SqsListener("deveops-queue")
    public void consumeMessage(@Payload Product product) {
        System.out.println("Received event message in EventConsumer : "+product);
        // Add your message processing logic here
        //populate events to database (dynamodb | RDS (MySQL))
    }


}
