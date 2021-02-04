package com.course.rabbitmqproducertwo;

import com.course.rabbitmqproducertwo.entity.DummyMessages;
import com.course.rabbitmqproducertwo.producer.DummyProducer;
import com.course.rabbitmqproducertwo.producer.MultiplePrefetchProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqProducerTwoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerTwoApplication.class, args);
    }

    @Autowired
    private MultiplePrefetchProducer dummyProducer;


    @Override
    public void run(String... args) throws Exception {

        dummyProducer.simulateScheduler();
        dummyProducer.simulateTransaction();

    }
}
