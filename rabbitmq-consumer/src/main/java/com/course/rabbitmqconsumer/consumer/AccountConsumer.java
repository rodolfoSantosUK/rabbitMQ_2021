package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class AccountConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(AccountConsumer.class);

    @RabbitListener(queues = "q.hr.accounting")
    public void listen(String message) {
        Employee emp = null;

        try {
            emp = objectMapper.readValue(message, Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Employee is {}", emp);
    }

}