package com.course.rabbitmqproducertwo.producer;

import com.course.rabbitmqproducertwo.entity.DummyMessages;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class DummyProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDummy(DummyMessages dummyMessages) {


        rabbitTemplate.convertAndSend("x.dummy", "",  dummyMessages);
    }
}
