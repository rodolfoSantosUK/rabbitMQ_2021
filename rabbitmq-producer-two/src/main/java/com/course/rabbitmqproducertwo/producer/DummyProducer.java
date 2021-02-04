package com.course.rabbitmqproducertwo.producer;

import com.course.rabbitmq.entity.DummyMessages;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class DummyProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDummy(DummyMessages dummyMessages) {


        rabbitTemplate.convertAndSend("x.dummy", "",  dummyMessages);
    }
}
