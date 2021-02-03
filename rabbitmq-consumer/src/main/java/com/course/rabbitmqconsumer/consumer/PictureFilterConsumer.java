package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class PictureFilterConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(PictureFilterConsumer.class);

    @RabbitListener(queues = "q.picture.filter")
    public void listen(String message) {
        Picture p = null;

        try {
            p = objectMapper.readValue(message, Picture.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("On image is {}", p.toString());
    }

}