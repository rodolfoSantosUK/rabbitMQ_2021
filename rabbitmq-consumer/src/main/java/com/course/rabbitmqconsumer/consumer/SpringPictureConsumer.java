package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Employee;
import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SpringPictureConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(SpringPictureConsumer.class);

    @RabbitListener(queues = "q.spring.image.work")
    public void listen(String  message)
            throws JsonParseException, JsonMappingException, IOException {
        var p = objectMapper.readValue(message, Picture.class);
        log.info("Consuming imagem : {} ", p.getName());
        if (p.getSize() > 9000) {
            throw new IOException("Image " + p.getName() + " size too large " + p.getSize());
        }

        log.info("Creating thumbnail & publishing image : {}", p.getName());
    }

    @RabbitListener(queues = "q.spring.vector.work")
    public void listenVector(String  message) throws JsonProcessingException {
        var p = objectMapper.readValue(message, Picture.class);
        log.info("Consuming vector : {} ", p.getName());
        log.info("Converting to image, creating  thumbnail & publishing image : {}", p.getName());
    }

}
