package com.course.rabbitmqconsumer.consumer;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class FixedRateConsumer {

	private final Logger log = LoggerFactory.getLogger(FixedRateConsumer.class);

	@RabbitListener(queues = "course.fixedrate", concurrency = "3")
	public void listen(String message) {
		log.info("Consuming {} on thread {}", message, Thread.currentThread().getName());
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
