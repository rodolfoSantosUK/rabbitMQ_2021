package com.course.rabbitmqconsumertwo.consumer;

import com.course.rabbitmqconsumertwo.entity.DummyMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MultiplePrefetchConsumer {

    private static final Logger log = LoggerFactory.getLogger(MultiplePrefetchConsumer.class);

    @RabbitListener(queues = "q.transaction", concurrency = "2")
    public void listenTransaction(DummyMessages dummyMessages) throws InterruptedException {
        log.info("Listening transaction: {}", dummyMessages);
        Thread.sleep(100);
    }

    @RabbitListener(queues = "q.scheduler", concurrency = "2", containerFactory = "prefetchContainerFactory")
    public void listenScheduler(DummyMessages dummyMessages) throws InterruptedException {
        log.info("Listening scheduler: {}", dummyMessages);
        Thread.sleep(60000);
    }

}
