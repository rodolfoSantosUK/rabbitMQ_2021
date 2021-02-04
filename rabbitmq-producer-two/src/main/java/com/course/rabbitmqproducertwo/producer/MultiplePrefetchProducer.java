package com.course.rabbitmqproducertwo.producer;

import com.course.rabbitmqproducertwo.entity.DummyMessages;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplePrefetchProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDummy(DummyMessages dummyMessages) {
            rabbitTemplate.convertAndSend("x.dummy", "", dummyMessages);
    }

    public void simulateTransaction() {
        for (int i = 0; i < 2000; i++) {
            var message = new DummyMessages(" scheduler " + i, 1);
            rabbitTemplate.convertAndSend("x.transaction", "", message);
        }
    }


    public void simulateScheduler() {
        for (int i = 0; i < 200; i++) {
            var message = new DummyMessages(" scheduler " + i, 1);
            rabbitTemplate.convertAndSend("x.scheduler", "", message);
        }
    }

}
