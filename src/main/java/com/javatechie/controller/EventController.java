package com.javatechie.controller;

import com.javatechie.dto.Product;
import com.javatechie.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventPublisher eventPublisher;


    @PostMapping("/publish")
    public String publishRawObj(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return eventPublisher.publishEvent(product);
    }
}
