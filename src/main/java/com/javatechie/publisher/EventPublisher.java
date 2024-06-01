package com.javatechie.publisher;

import com.javatechie.dto.Product;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class EventPublisher {

    public static final String QUEUE_ENDPOINT = "";

    @Autowired
    private SqsTemplate sqsTemplate;

    public String publishEvent(Product product) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<Product>> future = sqsTemplate.sendAsync(QUEUE_ENDPOINT, product);
        return "Message submitted to queue with ID "+future.get().messageId().toString();
    }


}
